package com.architect.kmpessentials.toast

import android.widget.Toast
import com.architect.kmpessentials.KmpAndroid

actual class KmpToast {
    actual companion object {
        actual fun setStyleOfToast(mode: ToastMode){

        }

        actual fun showToastShort(message: String) {
            Toast.makeText(KmpAndroid.applicationContext, message, Toast.LENGTH_SHORT).show()
        }

        actual fun showToastLong(message: String) {
            Toast.makeText(KmpAndroid.applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}