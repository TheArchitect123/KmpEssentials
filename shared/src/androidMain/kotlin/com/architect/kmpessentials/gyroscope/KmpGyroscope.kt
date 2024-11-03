package com.architect.kmpessentials.gyroscope

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionTripleFloatParams

actual class KmpGyroscope {
    actual companion object {
        internal lateinit var gyroScope: ActionTripleFloatParams
        private val sensorManager by lazy {
            KmpAndroid.applicationContext?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }
        private val gyroManager by lazy {
            sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        }

        actual fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        ) {
            gyroScope = gyroScopeVal
            sensorManager.registerListener(
                KmpAndroid.sensorManagerObserver,
                gyroManager!!,
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