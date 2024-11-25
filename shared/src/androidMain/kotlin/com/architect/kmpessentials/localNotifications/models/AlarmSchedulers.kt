package com.architect.kmpessentials.localNotifications.models

import kotlinx.serialization.Serializable

@Serializable
data class AlarmSchedulers(val resultCode: Int, val title: String, val message: String, val icon: Int, val epochScheduled: Long)