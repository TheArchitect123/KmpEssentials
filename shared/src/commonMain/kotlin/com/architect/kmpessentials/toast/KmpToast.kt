package com.architect.kmpessentials.toast

expect class KmpToast {
    companion object {
        fun setStyleOfToast(mode: ToastMode)
        fun showToastShort(message: String)
        fun showToastLong(message: String)
    }
}

