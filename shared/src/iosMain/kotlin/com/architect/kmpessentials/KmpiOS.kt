package com.architect.kmpessentials

import platform.UIKit.UIApplication
import platform.UIKit.UIViewController

object KmpiOS {
    fun getTopViewController() : UIViewController?{
        return UIApplication.sharedApplication.keyWindow?.rootViewController()
    }
}