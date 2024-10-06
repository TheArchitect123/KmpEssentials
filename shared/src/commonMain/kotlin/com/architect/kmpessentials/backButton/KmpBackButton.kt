package com.architect.kmpessentials.backButton

import com.architect.kmpessentials.aliases.DefaultAction

expect class KmpBackButton {
    companion object {
        fun disableBackButton()
        fun disableBackButtonOverrideWithCustomAction(customAction: DefaultAction)
        fun enableBackButton()
    }
}