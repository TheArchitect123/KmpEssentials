package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction

actual class KmpProximity {
    actual companion object {
        private var proximityScope: ActionBoolParams? = null

        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}