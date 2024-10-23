package com.architect.kmpessentials.backgrounding.requests

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import java.util.LinkedList
import java.util.Queue

class LongRunnerJob(context: Context, param: WorkerParameters) : CoroutineWorker(context, param) {
    companion object {
        val mutableTypes: Queue<DefaultActionAsync> = LinkedList()
    }

    override suspend fun doWork(): Result {
        try {
            mutableTypes.remove()()
        } catch (ex: Exception) {
            KmpLogging.writeErrorWithCode(ErrorCodes.BACKGROUND_TASK_FAILED)
            return Result.failure()
        }

        return Result.success()
    }


}


