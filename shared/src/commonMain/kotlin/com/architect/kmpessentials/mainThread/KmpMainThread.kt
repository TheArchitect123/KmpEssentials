package com.architect.kmpessentials.mainThread
import com.architect.kmpessentials.aliases.DefaultAction

expect class KmpMainThread {
    companion object {
        /** Run any action inside the main thread.
         * @param action the action that will be dispatched to the main thread
         * */
        fun runViaMainThread(action: DefaultAction)
    }
}