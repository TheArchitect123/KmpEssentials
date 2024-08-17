package com.architect.kmpessentials

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Build.VERSION_CODES
import com.architect.kmpessentials.battery.KmpBattery

class KmpAndroid {
    companion object {
        internal var hasRegistered: Boolean = false
        internal lateinit var applicationContext: Application
        internal lateinit var clientAppContext: Activity

        fun initializeApp(context: Activity) {
            clientAppContext = context
            if (!hasRegistered) {
                applicationContext = clientAppContext.application
                clientAppContext.application.registerActivityLifecycleCallbacks(KmpAndroidListener())
                if (Build.VERSION.SDK_INT == VERSION_CODES.LOLLIPOP) { // battery services require Lolliop and above to work
                    KmpBattery.initializeBatteryService()
                }

                hasRegistered = true
            }
        }
    }
}

