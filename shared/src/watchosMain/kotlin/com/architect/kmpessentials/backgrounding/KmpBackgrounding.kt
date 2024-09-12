package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import platform.Foundation.NSDate
import platform.Foundation.now
import platform.WatchKit.WKApplication
import platform.WatchKit.scheduleBackgroundRefreshWithPreferredDate

actual class KmpBackgrounding {
    actual companion object {
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultAction) {
            WKApplication.sharedApplication()
                .scheduleBackgroundRefreshWithPreferredDate(NSDate.now(), null) {
                    // expiration
                    action()
                }
        }
    }
}