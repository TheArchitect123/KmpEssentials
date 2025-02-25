package com.architect.kmpessentials.printing

import kotlinx.browser.window

actual class KmpPrinting {
    actual companion object {
        private fun printPage(path: String) {
            val cwindow = window.open(path)
            cwindow?.onload = {
                window.print() // print the loaded dialog
            }
        }

        actual fun printImageWithPath(path: String) {
            printPage(path)
        }

        actual fun printDocumentWithPath(path: String) {
            printPage(path)
        }

        actual fun printHtmlWithPath(path: String) {
            printPage(path)
        }

        actual fun isPrintingSupported(): Boolean {
            return window.asDynamic().print != undefined
        }
    }
}