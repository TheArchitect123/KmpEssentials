package com.architect.kmpessentials.mainThread

import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction

actual class KmpMainThread {
    actual companion object {
        actual fun runViaMainThread(action: DefaultAction) {
            KmpAndroid.clientAppContext.runOnUiThread {
                action()
            }
        }
    }
}