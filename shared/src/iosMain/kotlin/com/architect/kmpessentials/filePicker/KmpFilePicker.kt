package com.architect.kmpessentials.filePicker

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.filePicker.delegates.DocumentManyPickerDelegate
import com.architect.kmpessentials.filePicker.delegates.DocumentPickerDelegate
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.CoreServices.kUTTypePNG
import platform.UIKit.UIDocumentPickerMode
import platform.UIKit.UIDocumentPickerViewController

actual class KmpFilePicker {
    actual companion object {
        private val fileTypes = listOf("public.text", "com.adobe.pdf")
        actual fun getFileFromPicker(action: DefaultFileAction) {
            KmpMainThread.runViaMainThread {
                val documentPicker = UIDocumentPickerViewController(
                    documentTypes = fileTypes,
                    inMode = UIDocumentPickerMode.UIDocumentPickerModeOpen
                )
                documentPicker.setDelegate(DocumentPickerDelegate(action))

                KmpiOS.getTopViewController()?.presentViewController(documentPicker, true, null)
            }
        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            KmpMainThread.runViaMainThread {
                val documentPicker = UIDocumentPickerViewController(
                    documentTypes = fileTypes,
                    inMode = UIDocumentPickerMode.UIDocumentPickerModeOpen
                )
                documentPicker.setDelegate(DocumentManyPickerDelegate(actions))

                KmpiOS.getTopViewController()?.presentViewController(documentPicker, true, null)
            }
        }
    }
}

