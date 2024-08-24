package com.architect.kmpessentials.filePicker.delegates

import com.architect.kmpessentials.filePicker.DefaultManyFilesAction
import com.architect.kmpessentials.filePicker.File
import platform.Foundation.NSURL
import platform.UIKit.UIDocumentPickerDelegateProtocol
import platform.UIKit.UIDocumentPickerViewController
import platform.darwin.NSObject

class DocumentManyPickerDelegate(val action: DefaultManyFilesAction) : NSObject(),
    UIDocumentPickerDelegateProtocol {
    override fun documentPicker(
        controller: UIDocumentPickerViewController,
        didPickDocumentsAtURLs: List<*>
    ) {
        val mutableUrls = mutableListOf<File>()
        didPickDocumentsAtURLs.map { it as NSURL }.forEach {
            if (it.absoluteURL != null) {
                mutableUrls.add(File(
                    "",
                    it.absoluteURL!!.path!!
                ))
            }
        }

        action.invoke(mutableUrls)
    }
}