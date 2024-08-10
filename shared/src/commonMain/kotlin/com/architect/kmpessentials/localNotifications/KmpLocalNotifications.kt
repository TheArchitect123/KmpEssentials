package com.architect.kmpessentials.localNotifications

expect class KmpLocalNotifications {
    companion object{
        fun sendNotification(title: String, message: String)
    }
}