package com.architect.kmpessentials.permissions.helpers

import com.architect.kmpessentials.permissions.Permission
import org.bytedeco.javacv.OpenCVFrameGrabber
import java.io.File

object PermissionsHandler {
    fun isPermissionAutomaticallyGranted(permission: Permission): Boolean {
        return when (permission) {
            Permission.ExternalStorage -> verifyExternalStorageAccess()
            Permission.Camera -> verifyCameraAccess()
            Permission.Microphone, Permission.Speech -> verifyMicrophoneAccess()
            Permission.Flashlight -> verifyFlashlightAccess()
            Permission.Vibrator -> true
            Permission.Location, Permission.CoarseLocation -> false  // requires JNI (or platform commands) -- will do later
            Permission.PushNotifications -> false // requires platform checks
            Permission.Biometrics, Permission.Contacts, Permission.Calendar, Permission.Sms -> false
            else -> true
        }
    }

    private fun verifyExternalStorageAccess(): Boolean {
        return try {
            val file = File(System.getProperty("user.home"))
            file.canRead() && file.canWrite()
        } catch (e: SecurityException) {
            false
        }
    }

    private fun verifyCameraAccess(): Boolean {
        return try {
            val grabber = OpenCVFrameGrabber(0)
            grabber.start()
            grabber.stop()
            true // Camera is accessible
        } catch (e: Exception) {
            false // Camera access failed
        }
    }

    private fun verifyMicrophoneAccess(): Boolean {
        return try {
            val targetLine = javax.sound.sampled.AudioSystem.getTargetLineInfo(
                javax.sound.sampled.DataLine.Info(
                    javax.sound.sampled.TargetDataLine::class.java,
                    null
                )
            )
            targetLine.isNotEmpty()
        } catch (e: Exception) {
            false
        }
    }

    private fun verifyFlashlightAccess(): Boolean {
        return true
    }
}

