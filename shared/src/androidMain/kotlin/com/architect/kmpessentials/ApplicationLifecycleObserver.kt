import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.backgrounding.KmpBackgrounding
import com.architect.kmpessentials.logging.KmpLogging

class ApplicationLifecycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppClosed() {
        KmpLogging.writeInfo("KMP_ESSENTIALS_APP_STATE", "App is about to be closed. Attempting to clear all workers from running")
        if(!KmpAndroid.allowWorkersToRunBeyondApp) {
            KmpBackgrounding.cancelAllRunningWorkers()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        KmpLogging.writeInfo("KMP_ESSENTIALS_APP_STATE", "App is now running the background")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        KmpLogging.writeInfo("KMP_ESSENTIALS_APP_STATE", "App is now running in the foreground")
    }
}