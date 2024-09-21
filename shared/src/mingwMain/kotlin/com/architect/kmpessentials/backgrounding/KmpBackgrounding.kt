package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.aliases.DefaultActionAsync

actual class KmpBackgrounding {
    actual companion object {
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {

        }

        actual fun cancelAllRunningWorkers() {
        }
    }
}