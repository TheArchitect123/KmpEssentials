import platform.CoreMotion.CMMotionManager
import platform.WatchKit.WKApplication
import platform.WatchKit.WKInterfaceController

object KmpWatchKit {
    val motionManager = CMMotionManager()

    fun getRootWatchController(): WKInterfaceController? {
        return WKApplication.sharedApplication().rootInterfaceController()
    }
}