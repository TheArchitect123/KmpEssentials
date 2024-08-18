package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams

expect class KmpProximity {
    companion object {
        fun startListening(
            proximityScopeVal: ActionBoolParams
        )

        fun stopListening()
    }
}