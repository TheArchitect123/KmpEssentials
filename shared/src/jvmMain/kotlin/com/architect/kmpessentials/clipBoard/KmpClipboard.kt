package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.logging.KmpLogging
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection

actual class KmpClipboard {
    actual companion object {
        private val systemClipboard by lazy {
            Toolkit.getDefaultToolkit().systemClipboard
        }

        actual fun getTextFromClipboard(): String {
            return try {
                if (systemClipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                    systemClipboard.getData(DataFlavor.stringFlavor) as String
                } else {
                    ""
                }
            } catch (e: Exception) {
                KmpLogging.writeError("JVM_API", e.stackTraceToString())
                ""
            }
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {
            systemClipboard.setContents(StringSelection(textToCopy), null)
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}