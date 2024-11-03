package com.architect.kmpessentials.orientation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.orientation.OrientationState

typealias OrientationChange = (OrientationState) -> Unit
class OrientationChangeReceiver(val stateManager : OrientationChange) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_CONFIGURATION_CHANGED){
            when(KmpAndroid.applicationContext?.resources?.configuration?.orientation){
                Configuration.ORIENTATION_PORTRAIT -> stateManager(OrientationState.Portrait)
                Configuration.ORIENTATION_LANDSCAPE -> stateManager(OrientationState.Landscape)
                else -> stateManager(OrientationState.Unknown)
            }
        }
    }
}