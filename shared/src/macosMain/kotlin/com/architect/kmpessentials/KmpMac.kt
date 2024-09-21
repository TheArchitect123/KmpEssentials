import platform.AppKit.NSApplication
import platform.AppKit.NSViewController
import platform.CoreMotion.CMHeadphoneMotionManager

object KmpMac {

    // used for acc, gyro, magnotometer sensors api
    val motionManager = CMHeadphoneMotionManager()

    fun getTopViewController(): NSViewController? {
        return NSApplication.sharedApplication.keyWindow?.contentViewController()
    }
}