package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams

expect class KmpMagnometer {
    companion object {
        fun startListening(
            magScopeVal: ActionTripleFloatParams
        )

        fun stopListening()
    }
}