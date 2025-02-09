package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.NetworkInterface
import java.net.URL

actual class KmpConnectivity {
    actual companion object {
        actual fun isConnected(): Boolean {
            val url = URL("http://www.google.com")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "HEAD"
            connection.connectTimeout = 3000 // 3 seconds timeout
            connection.readTimeout = 3000
            return connection.responseCode in 200..399 // HTTP success codes
        }

        actual fun getCurrentNetworkName(): String? {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> try {
                    val process = Runtime.getRuntime().exec("netsh wlan show interfaces")
                    val reader = BufferedReader(InputStreamReader(process.inputStream))
                    reader.useLines { lines ->
                        lines.find { it.trim().startsWith("SSID") }?.split(":")?.get(1)?.trim()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }

                DevicePlatform.MacOS, DevicePlatform.Linux -> try {
                    val process = Runtime.getRuntime()
                        .exec("iwgetid -r") // requires iwgetid installed on user's mac (need validation to check if exists)
                    val reader = BufferedReader(InputStreamReader(process.inputStream))
                    reader.readLine() // The SSID is returned as the first line
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }

                else -> ""
            }
        }

        actual suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {

        }

        actual suspend fun getCurrentNetworkIPv4(): String? {
            return NetworkInterface.getNetworkInterfaces().toList()
                .flatMap { it.inetAddresses.toList() }
                .firstOrNull { it is java.net.Inet4Address && !it.isLoopbackAddress }?.hostAddress
        }

        actual suspend fun getCurrentNetworkIPv6(): String? {
            return NetworkInterface.getNetworkInterfaces().toList()
                .flatMap { it.inetAddresses.toList() }
                .firstOrNull { it is java.net.Inet6Address && !it.isLoopbackAddress }?.hostAddress
        }
    }
}