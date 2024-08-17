package com.architect.kmpessentials.textToSpeech

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread
import java.util.Locale

actual class KmpTextToSpeech {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    actual companion object {
        private var speechAction: SpeechActionResult? = null
        private val speechToText =
            SpeechRecognizer.createSpeechRecognizer(KmpAndroid.applicationContext)
        private val ttsEngine: TextToSpeech

        init {
            ttsEngine = TextToSpeech(
                KmpAndroid.applicationContext,
                { status ->
                    if (status == TextToSpeech.SUCCESS) {

                    } else {

                    }
                })

            ttsEngine.setLanguage(Locale.US)

            // speech to text service
            speechToText.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {

                }

                override fun onBeginningOfSpeech() {

                }

                override fun onRmsChanged(rmsdB: Float) {

                }

                override fun onBufferReceived(buffer: ByteArray?) {

                }

                override fun onEndOfSpeech() {

                }

                override fun onError(error: Int) {

                }

                override fun onResults(results: Bundle?) {
                    if (speechAction != null) {
                        val message =
                            results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                                ?.firstOrNull()
                        if (message != null) {
                            speechAction!!(message)
                        }
                    }
                }

                override fun onPartialResults(partialResults: Bundle?) {

                }

                override fun onEvent(eventType: Int, params: Bundle?) {

                }
            })
        }

        // must run from the main thread
        actual fun convertSpeechToText(response: SpeechActionResult) {
            if (SpeechRecognizer.isRecognitionAvailable(KmpAndroid.applicationContext)) {
                val recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                    putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                    )
                }
                recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")

                speechToText.startListening(recognizerIntent)
            }
        }

        actual fun convertTextToSpeech(message: String) {
            KmpMainThread.runViaMainThread {
                ttsEngine.speak(message, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }
}