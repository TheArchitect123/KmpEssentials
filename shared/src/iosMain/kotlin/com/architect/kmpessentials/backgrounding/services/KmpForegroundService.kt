package com.architect.kmpessentials.backgrounding.services

import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import platform.BackgroundTasks.*

class KmpForegroundService {
    companion object {
        private val appleDefaultLongRunningId =
            "com.kmpessentials.default.backgrounding.longrunning"
        internal var actionToInvoke: DefaultActionAsync? = null

        // required to be invoked by the users' app delegate before app launches
        fun registerBackgroundService() {
            BGTaskScheduler.sharedScheduler.registerForTaskWithIdentifier(
                appleDefaultLongRunningId,
                null
            ) { task ->
                if (task is BGProcessingTask) {
                    handleProcessingTask(task)
                }
            }
        }

        private fun handleProcessingTask(task: BGProcessingTask) {
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    val action = actionToInvoke
                    action?.invoke()

                    task.setTaskCompletedWithSuccess(success = true)
                } catch (e: Exception) {
                    task.setTaskCompletedWithSuccess(success = false)
                }
            }
        }

        @OptIn(ExperimentalForeignApi::class)
        internal fun invokeBackgroundService() {
            val request = BGProcessingTaskRequest(appleDefaultLongRunningId).apply {
                requiresNetworkConnectivity = false // Set this if the task requires internet
                requiresExternalPower = false // Set this if the task can run on battery
            }

            try {
                BGTaskScheduler.sharedScheduler.submitTaskRequest(request, null)
                println("Task scheduled successfully.")
            } catch (e: Exception) {
            }
        }
    }
}