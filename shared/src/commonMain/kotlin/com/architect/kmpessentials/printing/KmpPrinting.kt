package com.architect.kmpessentials.printing

expect class KmpPrinting {
    companion object{
        /**
         * Launches a Printing Job for the specified image at path
         * @param path file path of the image to print
         * */
        fun printImageWithPath(path: String) // launch
        /**
         * Launches a Printing Job for the specified document file at path
         * @param path file path of the document to print (file can be a PDF, Word, or excel, etc)
         * */
        fun printDocumentWithPath(path: String) // launch

        /**
         * Launches a Printing Job for the specified file at path
         * @param path file path of the document to print (this could be an image, a document, etc).
         * */
        fun printHtmlWithPath(path: String) // launch

        /**
         * Checks if printing is currently supported on the device.
         * True if device can establish a connection to a printer
         * False if not
         * */
        fun isPrintingSupported() : Boolean
    }
}