package com.architect.kmpessentials.printing

import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.Foundation.NSURLResponse
import platform.Foundation.NSURLSession
import platform.Foundation.dataTaskWithRequest
import platform.UIKit.UIPrintInfo
import platform.UIKit.UIPrintInfoOutputType
import platform.UIKit.UIPrintInteractionController

actual class KmpPrinting {
    actual companion object {

        private fun runPrintJob(filePath: String, printType: UIPrintInfoOutputType) {
            KmpMainThread.runViaMainThread {
                if (isPrintingSupported()) {
                    // check if file is remote
                    // if file is remote the file needs to be downloaded and cached locally, this then gets processed as a normal file
                    val imagePrintJob = UIPrintInfo()
                    imagePrintJob.outputType = printType

                    val printingController =
                        UIPrintInteractionController.sharedPrintController()
                    printingController.printInfo = imagePrintJob
                    if (filePath.startsWith("https")) {
                        GlobalScope.launch { // run data task async
                            NSURLSession.sharedSession()
                                .dataTaskWithRequest(NSURLRequest.requestWithURL(NSURL.URLWithString(filePath)!!)) { data, response, error ->
                                    if (error == null) {
                                        printingController.printingItem = data

                                        // configure metadata
                                        printingController.presentAnimated(true, null)
                                    }
                                }.resume()
                        }
                    } else {
                        val fileUrl = NSURL.fileURLWithPath(filePath)
                        if (UIPrintInteractionController.canPrintURL(
                                fileUrl
                            )
                        ) {
                            printingController.printingItem = fileUrl
                            printingController.presentAnimated(true, null)
                        }
                    }
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