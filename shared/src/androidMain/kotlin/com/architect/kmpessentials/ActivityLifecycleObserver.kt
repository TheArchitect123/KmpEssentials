package com.architect.kmpessentials

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityLifecycleObserver : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
        KmpAndroid.clientAppContext.lifecycle.addObserver(KmpAndroid.sensorManagerObserver)
    }

    override fun onActivityPaused(activity: Activity) {
        KmpAndroid.clientAppContext.lifecycle.removeObserver(KmpAndroid.sensorManagerObserver)
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
    }
}