package com.architect.kmpessentials.lifecycle

import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.coroutines.delay
import platform.Foundation.*
import platform.UIKit.*

actual class KmpLifecycle {

    actual companion object {
        private var backgroundAction: (() -> Unit)? = null
        private var foregroundAction: (() -> Unit)? = null
        private var isInForeground: Boolean = false

        init {
            // Register for lifecycle notifications
            setupLifecycleObservers()
        }

        /**
         *  Sets the action to run when the app enters the background state.
         */
        actual fun setAppLifecycleBackground(action: () -> Unit) {
            backgroundAction = action
        }

        /**
         *  Sets the action to run when the app enters the foreground state.
         */
        actual fun setAppLifecycleForeground(action: () -> Unit) {
            foregroundAction = action
        }

        actual suspend fun waitForAppToReturnToForeground(action: DefaultActionAsync) {
            while (!isInForeground) { // checks if the app returns to the foreground
                delay(1000)
            }

            action()
        }

        /**
         *  Resets all lifecycle actions.
         */
        actual fun resetAppLifecycleActions() {
            backgroundAction = null
            foregroundAction = null
        }

        /**
         *  Initializes the lifecycle observers.
         */
        private fun setupLifecycleObservers() {
            val notificationCenter = NSNotificationCenter.defaultCenter

            // Observe app entering the background
            notificationCenter.addObserverForName(
                name = UIApplicationDidEnterBackgroundNotification,
                `object` = null,
                queue = null
            ) { _ ->
                backgroundAction?.invoke()
                isInForeground = false
            }

            // Observe app entering the foreground
            notificationCenter.addObserverForName(
                name = UIApplicationWillEnterForegroundNotification,
                `object` = null,
                queue = null
            ) { _ ->
                foregroundAction?.invoke()
                isInForeground = true
            }
        }
    }
}