package com.architect.testclient.androidTest

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.backgrounding.KmpBackgrounding
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.testclient.android.MyApplicationTheme
import kotlinx.coroutines.delay

// This is the Main Activity for testing
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KmpAndroid.initializeApp(this)

        KmpLocalNotifications.setNotificationIcon(R.drawable.ic_launcher_background)
    //    KmpLocalNotifications.scheduleAlarmNotification(5000, "Hello", "Testing")
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            val permission = android.Manifest.permission.FOREGROUND_SERVICE_DATA_SYNC
//
//            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, arrayOf(permission), 1001)
//            }
//        }

        KmpBackgrounding.createAndStartForegroundWorker({
            while (true){
                delay(4000)
                KmpLogging.writeInfo("ForegroundServiceNotification", "Sample Notification")
          //      KmpLocalNotifications.sendNotification("Hello Foreground Service", "Hello there")
            }

        }, "Hello", "I'm running a foreground service task")

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // GreetingView(Greeting().greet())
                }
            }
        }
    }
}

fun writeCsv() {
    val row1 = listOf("a", "b", "c")
    val row2 = listOf("d", "e", "f")

//    val path = kotlin.io.path.Path(KmpFileSystem.getExternalStorageDirectory(), "test.csv")
//    KmpFileSystem.createFileAt(path.absolute().pathString)
//    csvWriter().open(path.absolute().pathString) {
//        writeRow(row1)
//        writeRow(row2)
//        writeRow("g", "h", "i")
//        writeRows(listOf(row1, row2))
//    }
//
//    KmpShare.addOptionalFlags(
//        listOf(
//            Intent.FLAG_GRANT_READ_URI_PERMISSION
//        )
//    )
//
//    KmpShare.setFileType(Mimes.csv).shareTextWithAnyApp(path.absolute().pathString, "TestCSV")
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
