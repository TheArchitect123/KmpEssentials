package com.architect.kmpessentials.toast

import kotlinx.cinterop.ObjCAction
import platform.UIKit.*
import platform.darwin.NSObject

class ToastHelper(
    private val snackbarView: UIView,
    private val action: (() -> Unit)?
) : NSObject() {

    @ObjCAction
    fun buttonTapped() {
        // Remove the snackbar view
        snackbarView.removeFromSuperview()

        // Perform the custom action if provided
        action?.invoke()
    }
}