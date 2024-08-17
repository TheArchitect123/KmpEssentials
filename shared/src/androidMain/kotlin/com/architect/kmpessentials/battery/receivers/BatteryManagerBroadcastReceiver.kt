package com.architect.kmpessentials.battery.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

typealias BatteryReceiver = (Intent?) -> Unit
class BatteryManagerBroadcastReceiver(val batteryState : BatteryReceiver) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        batteryState(intent)
    }
}