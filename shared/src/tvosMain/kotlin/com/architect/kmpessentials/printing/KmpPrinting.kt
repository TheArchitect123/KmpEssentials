package com.architect.kmpessentials.printing

actual class KmpPrinting {
    actual companion object {
        actual fun printImageWithPath(path: String) {

        }

        actual fun printDocumentWithPath(path: String) {

        }

        actual fun printHtmlWithPath(path: String) {

        }

        actual fun isPrintingSupported(): Boolean {
            return false
        }
    }
}