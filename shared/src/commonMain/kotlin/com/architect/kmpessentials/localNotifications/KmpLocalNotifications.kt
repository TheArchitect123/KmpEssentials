package com.architect.kmpessentials.localNotifications

expect class KmpLocalNotifications {
    companion object{
        /**
         * Broadcasts a local notification with the specified Title & Message
         * */
        fun sendNotification(title: String, message: String)
    }
}