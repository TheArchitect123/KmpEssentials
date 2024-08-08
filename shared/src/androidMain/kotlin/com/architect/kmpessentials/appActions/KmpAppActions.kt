package com.architect.kmpessentials.appActions

import android.os.Environment
import com.architect.kmpessentials.KmpAndroid

actual class KmpAppActions {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }
    }
}