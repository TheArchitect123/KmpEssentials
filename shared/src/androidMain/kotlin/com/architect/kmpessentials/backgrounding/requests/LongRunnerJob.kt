package com.architect.kmpessentials.backgrounding.requests

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.architect.kmpessentials.aliases.DefaultActionAsync

class LongRunnerJob(context: Context, param: WorkerParameters) : CoroutineWorker(context, param) {
    companion object {
        val mutableTypes = mutableListOf<DefaultActionAsync>()
    }

    override suspend fun doWork(): Result {
        try {
            mutableTypes.removeFirst()()
        } catch (ex: Exception) {
            return Result.failure()
        }

        return Result.success()
    }


}