package com.architect.kmpessentials

import platform.CoreMotion.CMMotionManager
import platform.UIKit.UIApplication
import platform.UIKit.UIViewController

object KmpiOS {

    // used for acc, gyro, magnotometer sensors api
    val motionManager = CMMotionManager()

    fun getTopViewController() : UIViewController?{
        return UIApplication.sharedApplication.keyWindow?.rootViewController()
    }
}