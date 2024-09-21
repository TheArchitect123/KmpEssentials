package com.architect.kmpessentials.clipBoard

import platform.AppKit.NSPasteboard
import platform.AppKit.NSPasteboardTypeString

actual class KmpClipboard {
    actual companion object {
        actual fun getTextFromClipboard(): String {
            return NSPasteboard.generalPasteboard.description() ?: ""
        }

        actual fun isSupported(): Boolean {
            return true
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {
            NSPasteboard.generalPasteboard.setString(textToCopy, NSPasteboardTypeString)
        }
    }
}