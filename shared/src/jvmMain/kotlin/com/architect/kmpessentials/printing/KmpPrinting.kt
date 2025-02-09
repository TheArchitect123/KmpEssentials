package com.architect.kmpessentials.printing

import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.printing.helpers.ImageHelper
import java.awt.Desktop
import java.awt.Graphics2D
import java.awt.print.Printable
import java.awt.print.PrinterException
import java.awt.print.PrinterJob
import java.io.File
import javax.imageio.ImageIO

actual class KmpPrinting {
    actual companion object {
        actual fun printImageWithPath(path: String) {
            val imageFile = File(path)
            if (!imageFile.exists()) {
                return
            }

            val image = ImageIO.read(imageFile) ?: run {
                return
            }

            val printJob = PrinterJob.getPrinterJob()
            printJob.setPrintable { graphics, pageFormat, pageIndex ->
                if (pageIndex > 0) return@setPrintable Printable.NO_SUCH_PAGE

                val g2d = graphics as Graphics2D
                g2d.translate(pageFormat.imageableX, pageFormat.imageableY)

                val scaledImage = ImageHelper.getScaledImage(
                    image,
                    pageFormat.imageableWidth.toInt(),
                    pageFormat.imageableHeight.toInt()
                )
                g2d.drawImage(scaledImage, 0, 0, null)

                Printable.PAGE_EXISTS
            }

            if (printJob.printDialog()) {
                try {
                    printJob.print()
                } catch (e: PrinterException) {
                    KmpLogging.writeError("JVM_APIS", e.stackTraceToString())
                }
            }
        }

        actual fun printDocumentWithPath(path: String) {
            val file = File(path)
            if (!file.exists()) {
                return
            }

            if (Desktop.isDesktopSupported() && Desktop.getDesktop()
                    .isSupported(Desktop.Action.PRINT)
            ) {
                Desktop.getDesktop().print(file)
            }
        }

        actual fun printHtmlWithPath(path: String) {
            val file = File(path)
            if (!file.exists()) {
                return
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI())
            }
        }

        actual fun isPrintingSupported(): Boolean {
            return PrinterJob.lookupPrintServices().isNotEmpty()
        }
    }
}