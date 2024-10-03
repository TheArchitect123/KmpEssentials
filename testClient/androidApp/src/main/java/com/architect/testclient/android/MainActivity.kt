package com.architect.testclient.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.flashlight.KmpFlashlight
import com.architect.kmpessentials.printing.KmpPrinting
import com.architect.kmpessentials.secureStorage.KmpSecureStorage
import com.architect.testclient.Greeting
import java.io.FileOutputStream

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KmpAndroid.initializeApp(this)

        KmpSecureStorage.configureDroidPreferenceFileName("hello")
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

    csvWriter().open("test.csv") {
        writeRow(row1)
        writeRow(row2)
        writeRow("g", "h", "i")
        writeRows(listOf(row1, row2))
    }

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
