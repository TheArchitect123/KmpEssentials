package com.architect.kmpessentials.deviceDisplay

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Pointer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

actual class KmpDeviceDisplay {
    actual companion object {

        internal var platformProcess: Process? = null

        interface Dxva2 : Library {
            fun setMonitorBrightness(hMonitor: Pointer?, brightness: Int): Boolean

            companion object {
                val INSTANCE: Dxva2 = Native.load("Dxva2", Dxva2::class.java)
            }
        }

        // Interface to map Windows API function
        interface Kernel32 : Library {
            fun setThreadExecutionState(flags: Int): Int

            companion object {
                val INSTANCE: Kernel32 = Native.load("kernel32", Kernel32::class.java)

                const val ES_CONTINUOUS: Int = -0x80000000
                const val ES_DISPLAY_REQUIRED: Int = 0x00000002
            }
        }

        actual fun keepScreenOnActive() {
            GlobalScope.launch {

                when (KmpDeviceInfo.getRunningPlatform()) {
                    DevicePlatform.Windows -> try {
                        Kernel32.INSTANCE.setThreadExecutionState(
                            Kernel32.ES_CONTINUOUS or Kernel32.ES_DISPLAY_REQUIRED
                        )
                    } catch (ex: Exception) {
                    }

                    DevicePlatform.MacOS -> {
                        try {
                            platformProcess = Runtime.getRuntime()
                                .exec("caffeinate") // use the caffeinate command to stop system sleep
                            platformProcess?.waitFor() // Keep the command running
                        } catch (e: IOException) {
                            e.printStackTrace()
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }

                    DevicePlatform.Linux -> {
                        try {
                            platformProcess = Runtime.getRuntime().exec("xdg-screensaver reset")
                            platformProcess?.waitFor()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }

                    else -> {

                    }
                }
            }
        }

        actual fun disableScreenOnActive() {
            platformProcess?.destroy()
            Kernel32.INSTANCE.setThreadExecutionState(Kernel32.ES_CONTINUOUS);
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            GlobalScope.launch {
                when (KmpDeviceInfo.getRunningPlatform()) {
                    DevicePlatform.Windows -> try {
                        val monitorHandle: Pointer? = null
                        Dxva2.INSTANCE.setMonitorBrightness(
                            monitorHandle,
                            (brightness * 100).roundToInt()
                        )
                    } catch (ex: Exception) {
                    }

                    DevicePlatform.MacOS -> {
                        val command = "brightness $brightness"
                        val process = Runtime.getRuntime().exec(command)
                        if (process.waitFor(5000, TimeUnit.MILLISECONDS)) {
                            process.destroy()
                        }
                    }

                    DevicePlatform.Linux ->
                        try {
                            val command = "xrandr --output eDP-1 --brightness $brightness"
                            val process = Runtime.getRuntime().exec(command)
                            if (process.waitFor(5000, TimeUnit.MILLISECONDS)) {
                                process.destroy()
                            }
                        } catch (ex: Exception) {
                        }
                    else -> print("Not Supported by JvmMain")
                }
            }
        }
    }
}