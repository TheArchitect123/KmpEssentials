package com.architect.kmpessentials.printing

import android.content.Context
import android.net.Uri
import android.os.Build
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.print.PrintHelper
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.printing.constants.FileExtensions
import java.io.File

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
actual class KmpPrinting {
    actual companion object {
        actual fun isPrintingSupported(): Boolean {
            return PrintHelper.systemSupportsPrint()
        }

        private val printerManager by lazy {
            KmpAndroid.clientAppContext.getSystemService(Context.PRINT_SERVICE) as PrintManager
        }

        actual fun printImageWithPath(path: String) {
            KmpMainThread.runViaMainThread {
                val printFile = File(path)
                if (isPrintingSupported() && printFile.exists()) {
                    PrintHelper(KmpAndroid.clientAppContext).also {
                        it.printBitmap(printFile.name, Uri.fromFile(printFile))
                    }
                }
            }
        }

        actual fun printDocumentWithPath(path: String) {
            var pathFormat = path
            if(path.endsWith(FileExtensions.PDF) && path.startsWith("https")){
                pathFormat = "https://docs.google.com/viewer?url=$path"
            }

            printHtmlWithPath(pathFormat)
        }

        actual fun printHtmlWithPath(path: String) {
            KmpMainThread.runViaMainThread {
                // load the html into a web view, and load that into a print documents adapter
                val webView = WebView(KmpAndroid.clientAppContext)
                webView.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView,
                        request: WebResourceRequest
                    ) = false

                    override fun onPageFinished(view: WebView, url: String) {
                        val htmlFile = File(path)
                        webView.createPrintDocumentAdapter(htmlFile.name)
                        printerManager.print(
                            htmlFile.name,
                            webView.createPrintDocumentAdapter(htmlFile.name),
                            PrintAttributes.Builder().build()
                        )
                    }
                }

                webView.loadUrl(path)
            }
        }
    }
}