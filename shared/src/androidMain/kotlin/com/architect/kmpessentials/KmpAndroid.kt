package com.architect.kmpessentials

import android.app.Activity

class KmpAndroid {
    companion object {
        internal lateinit var clientAppContext: Activity

        fun initializeApp(context: Activity) {
            clientAppContext = context
        }
    }
}