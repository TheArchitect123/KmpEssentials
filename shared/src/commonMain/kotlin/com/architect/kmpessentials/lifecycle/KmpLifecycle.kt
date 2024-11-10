package com.architect.kmpessentials.lifecycle

import com.architect.kmpessentials.aliases.DefaultAction

expect class KmpLifecycle {
   companion object {
       /**
        *  Registers an action that is run after the app enters the background state
        * */
       fun setAppLifecycleBackground(action: DefaultAction)

       /**
        *  Registers an action that is run after the app reenters the foreground state
        * */
       fun setAppLifecycleForeground(action: DefaultAction)

       /**
        *  Resets all the lifecycle actions.
        *  This is essential to invoke if using a fragment, or when an activity gets destroyed.
        *  This could cause a memory leak if not invoked
        *  Please invoke either in activity's or fragment's OnDestroy function to cleanup
        * */
       fun resetAppLifecycleActions()
   }
}