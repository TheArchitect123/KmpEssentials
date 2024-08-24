package com.architect.kmpessentials.filePicker.delegates

import com.architect.kmpessentials.filePicker.DefaultFileAction
import com.architect.kmpessentials.filePicker.File
import platform.Foundation.NSURL
import platform.UIKit.UIDocumentPickerDelegateProtocol
import platform.UIKit.UIDocumentPickerViewController
import platform.darwin.NSObject

class DocumentPickerDelegate(private val action: DefaultFileAction) : NSObject(), UIDocumentPickerDelegateProtocol {
    override fun documentPicker(
        controller: UIDocumentPickerViewController,
        didPickDocumentAtURL: NSURL
    ) {
        action.invoke(File(
            didPickDocumentAtURL.description() ?: "",
            didPickDocumentAtURL.absoluteURL?.absoluteString ?: ""
        ))
    }
}


