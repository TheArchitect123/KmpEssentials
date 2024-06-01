package com.architect.kmpessentials

import android.content.Context

class KmpAndroid {
    companion object {
        internal lateinit var clientAppContext: Context

        fun initializeApp(context: Context) {
            clientAppContext = context
        }
    }
}