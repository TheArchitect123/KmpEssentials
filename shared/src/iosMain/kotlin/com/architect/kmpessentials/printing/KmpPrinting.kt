package com.architect.kmpessentials.printing

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.Foundation.NSURL
import platform.UIKit.UIPrintInfo
import platform.UIKit.UIPrintInfoOutputType
import platform.UIKit.UIPrintInteractionController

actual class KmpPrinting {
    actual companion object {

        private fun runPrintJob(filePath: String, printType: UIPrintInfoOutputType) {
            KmpMainThread.runViaMainThread {
                // check if file is remote
                // if file is remote the file needs to be downloaded and cached locally, this then gets processed as a normal file

                if(filePath.startsWith("https")){

                }

                val fileUrl = NSURL.fileURLWithPath(filePath)
                if (isPrintingSupported() && UIPrintInteractionController.canPrintURL(
                        fileUrl
                    )
                ) {
                    val imagePrintJob = UIPrintInfo()
                    imagePrintJob.outputType = printType

                    val printingController = UIPrintInteractionController.sharedPrintController()
                    printingController.printInfo = imagePrintJob
                    printingController.printingItem = fileUrl

                    // configure metadata
                    printingController.presentAnimated(true, null)
                }
            }
        }

        actual fun printImageWithPath(path: String) {
            runPrintJob(path, UIPrintInfoOutputType.UIPrintInfoOutputPhoto)
        }

        actual fun printDocumentWithPath(path: String) {
            runPrintJob(path, UIPrintInfoOutputType.UIPrintInfoOutputPhoto)
        }

        actual fun printHtmlWithPath(path: String) {
            runPrintJob(path, UIPrintInfoOutputType.UIPrintInfoOutputGeneral)
        }

        actual fun isPrintingSupported(): Boolean {
            return UIPrintInteractionController.isPrintingAvailable()
        }
    }
}