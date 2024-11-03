package com.architect.kmpessentials.backgrounding

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.requests.LongRunnerJob
import com.architect.kmpessentials.backgrounding.requests.LongRunnerJobWithoutCancel
import java.util.UUID

actual class KmpBackgrounding {
    actual companion object {
        private val workManager by lazy {
            WorkManager.getInstance(KmpAndroid.applicationContext!!)
        }

        private val workerJobs = mutableListOf<UUID>()
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
            val constraints =
                Constraints.Builder()
            if (options != null) {
                if (options.requiresInternet) {
                    constraints.setRequiredNetworkType(NetworkType.CONNECTED)
                }
                if (options.requiresStorage) {
                    constraints.setRequiresStorageNotLow(true)
                }
                if (options.requiresSufficientBattery) {
                    constraints.setRequiresBatteryNotLow(true)
                }
            }

            LongRunnerJob.mutableTypes.add(action)

            val singleJob = OneTimeWorkRequest.Builder(
                LongRunnerJob::class.java
            ).setConstraints(constraints.build()).build()

            workerJobs.add(singleJob.id)
            workManager.enqueue(singleJob)
        }

        actual fun createAndStartWorkerWithoutCancel(options: BackgroundOptions?, action: DefaultActionAsync){
            val constraints =
                Constraints.Builder()
            if (options != null) {
                if (options.requiresInternet) {
                    constraints.setRequiredNetworkType(NetworkType.CONNECTED)
                }
                if (options.requiresStorage) {
                    constraints.setRequiresStorageNotLow(true)
                }
                if (options.requiresSufficientBattery) {
                    constraints.setRequiresBatteryNotLow(true)
                }
            }

            LongRunnerJobWithoutCancel.mutableTypes.add(action)

            val singleJob = OneTimeWorkRequest.Builder(
                LongRunnerJobWithoutCancel::class.java
            ).setConstraints(constraints.build()).build()

            workManager.enqueue(singleJob)
        }

        actual fun cancelAllRunningWorkers() {
            if (workerJobs.isNotEmpty()) {
                workerJobs.forEach {
                    workManager.cancelWorkById(it)
                }
            }

            workerJobs.clear()
            LongRunnerJob.mutableTypes.clear()
        }
    }
}