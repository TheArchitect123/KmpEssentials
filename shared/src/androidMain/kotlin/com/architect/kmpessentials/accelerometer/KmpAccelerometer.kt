package com.architect.kmpessentials.accelerometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionTripleFloatParams

actual class KmpAccelerometer {
    actual companion object {
        internal lateinit var accScope: ActionTripleFloatParams
        private val sensorManager by lazy {
            KmpAndroid.applicationContext?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }
        private val accManager by lazy {
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

        actual fun startListening(
            accScopeVal: ActionTripleFloatParams
        ) {
            accScope = accScopeVal
            sensorManager.registerListener(
                KmpAndroid.sensorManagerObserver,
                accManager!!,
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