package com.architect.kmpessentials

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.lifecycle.DefaultLifecycleObserver
import com.architect.kmpessentials.accelerometer.KmpAccelerometer
import com.architect.kmpessentials.gyroscope.KmpGyroscope
import com.architect.kmpessentials.magnotometer.KmpMagnometer
import com.architect.kmpessentials.proximity.KmpProximity

class SensorObserver : DefaultLifecycleObserver, SensorEventListener {
    private val SENSOR_SENSITIVITY: Int = 4
    override fun onSensorChanged(event: SensorEvent?) {
        // accelerometer
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            KmpAccelerometer.accScope.invoke(Triple(x, y, z))
        }

        // gyroscope
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            KmpGyroscope.gyroScope.invoke(Triple(x, y, z))
        }

        //magnetometer
        if (event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            KmpMagnometer.magScope.invoke(Triple(x, y, z))
        }

        // proximity sensor
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            val isTriggered =
                event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY
            KmpProximity.proxScope.invoke(isTriggered)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

