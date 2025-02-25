package com.architect.kmpessentials.permissions

enum class Permission {
    Camera,
    Flashlight,
    ExternalStorage,
    Location,
    PhotoGallery,
    Speech,

    /**Android Specific Permission*/
    CoarseLocation,
    Sms,
    Microphone,
    PushNotifications,
    Biometrics,
    Contacts,
    Vibrator,
    Calendar,

    // sensors (web specific)
    Magnetometer,
    Accelerometer,
    Gyroscope
}

