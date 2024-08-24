package com.architect.kmpessentials.backgrounding

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.requests.LongRunnerJob

actual class KmpBackgrounding {
    actual companion object {
        actual fun createAndStartWorker(options: BackgroundOptions, action: DefaultAction) {
            val constraints =
                Constraints.Builder()
            if (options.requiresInternet) {
                constraints.setRequiredNetworkType(NetworkType.CONNECTED)
            }
            if (options.requiresStorage) {
                constraints.setRequiresStorageNotLow(true)
            }
            if (options.requiresSufficientBattery) {
                constraints.setRequiresBatteryNotLow(true)
            }

            LongRunnerJob.mutableTypes.add(action)
            WorkManager.getInstance(KmpAndroid.applicationContext).enqueue(
                OneTimeWorkRequest.Builder(
                    LongRunnerJob::class.java
                ).setConstraints(constraints.build())
                    .build()
            )
        }
    }
}