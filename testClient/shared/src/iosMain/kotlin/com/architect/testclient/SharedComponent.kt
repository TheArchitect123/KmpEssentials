package com.architect.testclient

import com.architect.kmpessentials.backgrounding.KmpBackgrounding
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

actual class SharedComponent {
    actual companion object {
        actual fun runNativeHandler() {
            KmpPermissionsManager.requestPermission(Permission.PushNotifications) {
                KmpBackgrounding.createAndStartForegroundWorker("Sample", "Test") {
                    var item = 1000
                    while (item >= 0) {
                        item--
                        KmpLogging.writeInfo("TESTING", "RUNNING_LOG_TEST")
                        delay(1000)

                        KmpLocalNotifications.sendNotification("Sample Test $item", "Testing again")
                    }
                }
            }
        }
    }

}