package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.fileSystem.KmpFileSystem
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.logging.KmpLogging
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.imageio.ImageIO

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        )
        {
            try {
                val timestamp =
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
                val outputFile =
                    File(KmpFileSystem.getAppDirectory() + "generated_screenshot_$timestamp.png")
                ImageIO.write(
                    Robot().createScreenCapture(Rectangle(Toolkit.getDefaultToolkit().screenSize)),
                    "png",
                    outputFile
                )
                action(outputFile.absolutePath)
            } catch (e: Exception) {
                KmpLogging.writeError("JVM_APIS", e.stackTraceToString())
            }
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}