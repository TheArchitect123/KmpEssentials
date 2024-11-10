package com.architect.kmpessentials.lifecycle

import com.architect.kmpessentials.aliases.DefaultAction

actual class KmpLifecycle {
    actual companion object {
        internal var backgroundAction: DefaultAction? = null
        internal var foregroundAction: DefaultAction? = null

        /**
         *  Registers an action that is run after the app enters the background state
         * */
        actual fun setAppLifecycleBackground(action: DefaultAction) {
            backgroundAction = action
        }

        /**
         *  Registers an action that is run after the app reenters the foreground state
         * */
        actual fun setAppLifecycleForeground(action: DefaultAction) {
            foregroundAction = action
        }

        /**
         *  Resets all the lifecycle actions.
         *  This is essential to invoke if using a fragment, or when an activity gets destroyed.
         *  This could cause a memory leak if not invoked
         *  Please invoke either in activity's or fragment's OnDestroy function to cleanup
         * */
        actual fun resetAppLifecycleActions() {
            backgroundAction = null
            foregroundAction = null
        }
    }
}