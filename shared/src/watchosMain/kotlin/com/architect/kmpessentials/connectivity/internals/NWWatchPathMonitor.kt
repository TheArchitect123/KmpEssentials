package com.architect.kmpessentials.connectivity.internals

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.convert
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import platform.Network.nw_interface_type_cellular
import platform.Network.nw_interface_type_other
import platform.Network.nw_interface_type_wifi
import platform.Network.nw_interface_type_wired
import platform.Network.nw_path_get_status
import platform.Network.nw_path_monitor_cancel
import platform.Network.nw_path_monitor_create
import platform.Network.nw_path_monitor_set_queue
import platform.Network.nw_path_monitor_set_update_handler
import platform.Network.nw_path_monitor_start
import platform.Network.nw_path_status_satisfied
import platform.Network.nw_path_t
import platform.Network.nw_path_uses_interface_type
import platform.darwin.dispatch_get_global_queue
import platform.posix.QOS_CLASS_BACKGROUND

@OptIn(UnsafeNumber::class)
internal class NWWatchPathMonitor{

    private val monitor = nw_path_monitor_create()

    private val connectionBroadcaster = MutableStateFlow<ConnectionType?>(null)

    private var path: nw_path_t = null

    init {
        // import platform.darwin.DISPATCH_QUEUE_PRIORITY_DEFAULT
        @OptIn(ExperimentalForeignApi::class)
        val queue = dispatch_get_global_queue(QOS_CLASS_BACKGROUND.convert(), 0.convert())
        nw_path_monitor_set_update_handler(monitor) { path ->
            this.path = path
            connectionBroadcaster.value = getNetworkConnectionFromPath(path)
        }
        nw_path_monitor_set_queue(monitor, queue)
        nw_path_monitor_start(monitor)
    }

    fun clear() {
        nw_path_monitor_cancel(monitor)
    }

    fun isConnected(): Boolean = nw_path_get_status(path) == nw_path_status_satisfied

    fun getCurrentNetworkConnection(): ConnectionType? =
        getNetworkConnectionFromPath(path)

    private fun getNetworkConnectionFromPath(path: nw_path_t): ConnectionType? = when {
        // The network interface type used for communication over Wi-Fi networks.
        nw_path_uses_interface_type(path, nw_interface_type_wifi) -> ConnectionType.WIFI
        // The network interface type used for communication over cellular networks.
        nw_path_uses_interface_type(path, nw_interface_type_cellular) -> ConnectionType.MOBILE
        // The network interface type used for communication over wired Ethernet networks.
        nw_path_uses_interface_type(path, nw_interface_type_wired) -> ConnectionType.ETHERNET
        // The network interface type used for communication over virtual networks or networks of unknown types.
        nw_path_uses_interface_type(
            path,
            nw_interface_type_other
        ) -> ConnectionType.UNKNOWN_CONNECTION_TYPE

        else -> null
    }

    fun observeNetworkConnection(): Flow<ConnectionType?> = connectionBroadcaster
}

