package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.darwin.NSObject

actual class KmpProximity {
    actual companion object {
        private var proximityScope: ActionBoolParams? = null

        @OptIn(BetaInteropApi::class)
        private val proximityListener = object : NSObject() {
            @Suppress("unused")
            @ObjCAction
            fun proximityTriggered(arg: NSNotification) {

            }
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}