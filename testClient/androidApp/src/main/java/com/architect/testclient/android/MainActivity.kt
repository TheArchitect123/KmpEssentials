package com.architect.testclient.androidTest

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.email.KmpEmail
import com.architect.kmpessentials.fileSystem.KmpFileSystem
import com.architect.kmpessentials.flashlight.KmpFlashlight
import com.architect.kmpessentials.internal.Mimes
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import com.architect.kmpessentials.printing.KmpPrinting
import com.architect.kmpessentials.secureStorage.KmpSecureStorage
import com.architect.kmpessentials.share.KmpShare
import com.architect.kmpessentials.toast.KmpToast
import com.architect.testclient.Greeting
import com.architect.testclient.android.MyApplicationTheme
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.FileOutputStream
import kotlin.io.path.absolute
import kotlin.io.path.pathString

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KmpAndroid.initializeApp(this)

        KmpSecureStorage.configureDroidPreferenceFileName("hello")
        writeCsv()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting().greet())
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
