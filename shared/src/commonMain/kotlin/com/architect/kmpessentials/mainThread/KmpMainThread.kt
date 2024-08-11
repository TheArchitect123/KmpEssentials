package com.architect.kmpessentials.mainThread
import com.architect.kmpessentials.aliases.DefaultAction

expect class KmpMainThread {
    companion object {
        fun runViaMainThread(action: DefaultAction)
    }
}