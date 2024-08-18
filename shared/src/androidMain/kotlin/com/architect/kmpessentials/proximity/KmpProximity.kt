package com.architect.kmpessentials.proximity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionBoolParams


actual class KmpProximity {
    actual companion object {
        internal lateinit var proxScope: ActionBoolParams
        private val sensorManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }
        private val proxManager by lazy {
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        }

        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {
            proxScope = proximityScopeVal
            sensorManager.registerListener(
                KmpAndroid.sensorManagerObserver,
                proxManager!!,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }

        actual fun stopListening() {
            sensorManager.unregisterListener(
                KmpAndroid.sensorManagerObserver
            )
        }
    }
}