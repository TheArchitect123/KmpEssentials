package com.architect.kmpessentials.toast

expect class KmpToast {
    companion object {
        fun showToastShort(message: String)
        fun showToastLong(message: String)
    }
}