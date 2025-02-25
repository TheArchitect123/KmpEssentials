package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.browser.window
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

actual class KmpConnectivity {
    actual companion object {
        actual fun isConnected(): Boolean {
            return window.navigator.asDynamic().onLine as Boolean
        }

        actual fun getCurrentNetworkName(): String? {
            val connection = window.navigator.asDynamic().connection
            return connection?.type as? String ?: ""
        }

        actual suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {
            window.addEventListener("online", { connectionState(true) })
            window.addEventListener("offline", { connectionState(false) })
        }

        actual suspend fun getCurrentNetworkIPv4(): String? {
            return getLocalIPAddress(false)
        }

        actual suspend fun getCurrentNetworkIPv6(): String? {
            return getLocalIPAddress(true)
        }

        private suspend fun getLocalIPAddress(ipv6: Boolean = false): String? =
            suspendCancellableCoroutine { continuation ->
                val rtc = js("new RTCPeerConnection({iceServers: []})")
                rtc.createDataChannel("")

                rtc.onicecandidate = { event: dynamic ->
                    val candidate = event.asDynamic().candidate
                    if (candidate != null) {
                        val ipRegex =
                            if (ipv6) Regex("""([a-fA-F0-9:]+)""") else Regex("""(\d{1,3}(\.\d{1,3}){3})""")
                        val match = ipRegex.find(candidate.candidate as String)
                        if (match != null) {
                            continuation.resume(match.value)
                            rtc.close()
                        }
                    }
                }

                rtc.createOffer().then { offer ->
                    rtc.setLocalDescription(offer)
                }
            }
    }
}