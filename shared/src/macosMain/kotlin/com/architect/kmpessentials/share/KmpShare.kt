package com.architect.kmpessentials.share

actual class KmpShare {
    actual companion object {
        private var fileType = ""

        actual fun setFileType(cFileType: String): Companion {
            fileType = cFileType
            return this
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {

        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {

        }
    }
}