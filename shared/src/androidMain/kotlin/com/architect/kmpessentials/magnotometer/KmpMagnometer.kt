package com.architect.kmpessentials.magnotometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.internal.ActionTripleFloatParams

actual class KmpMagnometer {
    actual companion object {
        internal lateinit var magScope: ActionTripleFloatParams
        private val sensorManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }
        private val magManager by lazy {
            sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        }

        actual fun startListening(
            magScopeVal: ActionTripleFloatParams
        ) {
            magScope = magScopeVal
            sensorManager.registerListener(
                KmpAndroid.sensorManagerObserver,
                magManager!!,
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