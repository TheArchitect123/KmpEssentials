package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams

actual class KmpProximity {
    actual companion object {
        private var proximityScope: ActionBoolParams? = null

        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}