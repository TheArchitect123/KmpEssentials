package com.architect.kmpessentials.mainThread

import com.architect.kmpessentials.aliases.DefaultAction
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

actual class KmpMainThread {
    actual companion object {
        actual fun runViaMainThread(action: DefaultAction) {
            dispatch_async(dispatch_get_main_queue()) {
                action()
            }
        }
    }
}