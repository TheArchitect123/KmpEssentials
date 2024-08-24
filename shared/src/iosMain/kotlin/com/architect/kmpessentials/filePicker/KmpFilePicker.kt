package com.architect.kmpessentials.filePicker

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.filePicker.delegates.DocumentManyPickerDelegate
import com.architect.kmpessentials.filePicker.delegates.DocumentPickerDelegate
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIDocumentPickerViewController

actual class KmpFilePicker {
    actual companion object  {
        actual fun getFileFromPicker(action: DefaultFileAction) {
            KmpMainThread.runViaMainThread {
                val documentPicker = UIDocumentPickerViewController()
                documentPicker.setDelegate(DocumentPickerDelegate(action))

                KmpiOS.getTopViewController()?.presentViewController(documentPicker, true, null)
            }
        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            KmpMainThread.runViaMainThread {
                val documentPicker = UIDocumentPickerViewController()
                documentPicker.setDelegate(DocumentManyPickerDelegate(actions))

                KmpiOS.getTopViewController()?.presentViewController(documentPicker, true, null)
            }
        }
    }
}

