package com.architect.kmpessentials.logging

import co.touchlab.kermit.Logger

class KmpLogging {
    companion object {
        fun writeInfo(tag: String, message: String) {
            Logger.i(tag = tag, messageString = message)
        }

        fun writeError(tag: String, message: String) {
            Logger.e(tag = tag, messageString = message)
        }

        fun writeErrorWithCode(errorCode: String) {
            Logger.e(tag = errorCode, messageString = "Detected error $errorCode. Please visit for more information, https://thearchitect123.github.io/ArtifactsDocProduction/develop/kotlin/multiplatform/kmpessentials/modules/errorCodes")
        }

        fun writeInfoWithCode(errorCode: String) {
            Logger.i(tag = errorCode, messageString = "$errorCode. Please visit for more information, https://thearchitect123.github.io/ArtifactsDocProduction/develop/kotlin/multiplatform/kmpessentials/modules/errorCodes")
        }

        fun writeException(tag: String, exception: Exception) {
            Logger.e(tag = tag, messageString = exception.message ?: exception.stackTraceToString())
        }
    }
}