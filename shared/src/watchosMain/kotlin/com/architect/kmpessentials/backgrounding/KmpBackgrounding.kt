package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.Foundation.NSDate
import platform.Foundation.now
import platform.WatchKit.WKApplication
import platform.WatchKit.scheduleBackgroundRefreshWithPreferredDate

actual class KmpBackgrounding {
    actual companion object {
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
            WKApplication.sharedApplication()
                .scheduleBackgroundRefreshWithPreferredDate(NSDate.now(), null) {
                    // expiration
                    GlobalScope.launch {
                        action()
                    }
                }
        }

        actual fun cancelAllRunningWorkers() {
        }
    }
}