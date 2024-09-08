import platform.WatchKit.WKApplication
import platform.WatchKit.WKInterfaceController

object KmpWatchKit {

    fun getRootWatchController(): WKInterfaceController? {
        return WKApplication.sharedApplication().rootInterfaceController()
    }
}