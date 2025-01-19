package com.architect.kmpessentials.appActions

expect class KmpAppActions {
    companion object{
        fun isSupported(): Boolean

//        fun addDynamicShortcut(id: String, shortLabel: String, longLabel: String)
//        fun removeDynamicShortcut(id: String)
//        fun removeAllDynamicShortcut()
//
//        fun addAssistantShortcut(id: String, phraseCommand: String)
//        fun removeAssistantShortcut(id: String)
    }
}