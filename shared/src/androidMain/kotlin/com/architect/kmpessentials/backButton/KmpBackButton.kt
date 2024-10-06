package com.architect.kmpessentials.backButton

import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction

actual class KmpBackButton {
    actual companion object {
        actual fun disableBackButton() {
            KmpAndroid.backButtonCallBack.isEnabled = true
            KmpAndroid.customBackAction = null
        }

        actual fun disableBackButtonOverrideWithCustomAction(customAction: DefaultAction) {
            KmpAndroid.backButtonCallBack.isEnabled = true
            KmpAndroid.customBackAction = customAction
        }

        actual fun enableBackButton() {
            KmpAndroid.backButtonCallBack.isEnabled = false
        }
    }
}