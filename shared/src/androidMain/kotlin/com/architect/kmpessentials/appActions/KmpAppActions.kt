package com.architect.kmpessentials.appActions

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import com.google.assistant.suggestion.AssistantSuggestions

actual class KmpAppActions {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }

//        private var shortcutIcon = 0
//        fun setShortcutIcon(shortcutIcon: Int) {
//            this.shortcutIcon = shortcutIcon
//        }
//
//        @RequiresApi(Build.VERSION_CODES.O)
//        actual fun addDynamicShortcut(id: String, shortLabel: String, longLabel: String) {
//            val context = KmpAndroid.getCurrentApplicationContext()
//            val shortcutManager = context.getSystemService(ShortcutManager::class.java)
//
//            // Check if the device supports shortcuts
//            if (shortcutManager?.isRequestPinShortcutSupported == true) {
//                val shortcuts = listOf(
//                    ShortcutInfo.Builder(context, id)
//                        .setShortLabel(shortLabel)
//                        .setLongLabel(longLabel)
//                        .setIcon(
//                            Icon.createWithResource(
//                                context,
//                                shortcutIcon
//                            )
//                        )
////                        .setIntent(
////                            Intent(context, Feature1Activity::class.java).apply {
////                                action = Intent.ACTION_VIEW
////                            }
////                        )
//                        .build(),
//                )
//
//                // Set or update shortcuts
//                shortcutManager.dynamicShortcuts = shortcuts
//            }
//        }
//
//        @RequiresApi(Build.VERSION_CODES.N_MR1)
//        actual fun removeDynamicShortcut(id: String) {
//            val shortcutManager = KmpAndroid.getCurrentApplicationContext().getSystemService(
//                ShortcutManager::class.java
//            )
//            shortcutManager?.removeAllDynamicShortcuts()
//        }
//
//        @RequiresApi(Build.VERSION_CODES.N_MR1)
//        actual fun removeAllDynamicShortcut() {
//            val shortcutManager = KmpAndroid.getCurrentApplicationContext()
//                .getSystemService(ShortcutManager::class.java)
//            shortcutManager?.removeAllDynamicShortcuts()
//        }
//
//        actual fun addAssistantShortcut(id: String, phraseCommand: String) {
////            val shortcutsClient = AssistantShortcutsSuggestionsClient.create(context)
////            // Define the shortcut details
////            val shortcut = Shortcut.Builder("shortcut_id_1")
////                .setType(ShortcutType.DYNAMIC)
////                .setCapabilityName("actions.intent.OPEN_APP_FEATURE")
////                .setEntityName("Feature Name")
////                .setDescription("Open Feature 1 in the app")
////                .setActionExecutor(object : ActionExecutor {
////                    override suspend fun execute(arguments: Map<String, Any>): ExecutionResult<Void> {
////                        // Handle the shortcut invocation
////                        return ExecutionResult.success()
////                    }
////                })
////                .build()
////
////            // Suggest the shortcut to Google Assistant
////            shortcutsClient.addShortcuts(listOf(shortcut))
//        }
//
//        actual fun removeAssistantShortcut(id: String) {
//
//        }
    }
}