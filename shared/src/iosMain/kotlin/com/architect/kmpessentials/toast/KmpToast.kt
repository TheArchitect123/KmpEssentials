package com.architect.kmpessentials.toast

import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.*
import platform.CoreGraphics.*
import kotlinx.cinterop.useContents
import platform.Foundation.NSSelectorFromString
import platform.Foundation.NSTimer

actual class KmpToast {
    actual companion object {
        actual fun setStyleOfToast(mode: ToastMode){

        }

        @OptIn(ExperimentalForeignApi::class)
        private fun invokeToastMessage(message: String, timer: Double){
            KmpMainThread.runViaMainThread {
                val keyWindow = UIApplication.sharedApplication.keyWindow
                val rootViewController = keyWindow?.rootViewController
                rootViewController?.view?.let { parentView ->
                    // Snackbar container
                    val snackbarView = UIView(
                        frame = CGRectMake(
                            16.0,
                            parentView.frame.useContents { size.height - 100.0 },
                            parentView.frame.useContents { size.width - 32.0 },
                            50.0
                        )
                    )
                    snackbarView.backgroundColor = UIColor.blackColor
                    snackbarView.layer.cornerRadius = 8.0
                    snackbarView.alpha = 0.0 // Start invisible

                    // Message label
                    val messageLabel = UILabel(
                        frame = CGRectMake(
                            16.0,
                            0.0,
                            snackbarView.frame.useContents { size.width - 100.0 },
                            snackbarView.frame.useContents { size.height })
                    )
                    messageLabel.text = message
                    messageLabel.textColor = UIColor.whiteColor
                    messageLabel.font = UIFont.systemFontOfSize(14.0)
                    messageLabel.numberOfLines = 0
                    snackbarView.addSubview(messageLabel)

                    // Action button (optional)
                    val actionButton = UIButton.buttonWithType(UIButtonTypeSystem)
                    actionButton.setFrame(CGRectMake(snackbarView.frame.useContents { size.width - 84.0 },
                        0.0,
                        80.0,
                        snackbarView.frame.useContents { size.height }))

                    actionButton.setTitle("Got it", forState = UIControlStateNormal)
                    actionButton.setTitleColor(
                        UIColor.systemBlueColor,
                        forState = UIControlStateNormal
                    )
                    actionButton.addTarget(ToastHelper(snackbarView, {

                    }),
                        action = NSSelectorFromString("buttonTapped"),
                        forControlEvents = UIControlEventTouchUpInside)
                    snackbarView.addSubview(actionButton)

                    // Add snackbar to parent view
                    parentView.addSubview(snackbarView)

                    // Animate appearance
                    UIView.animateWithDuration(0.3, animations = {
                        snackbarView.alpha = 1.0 // Fade in
                        snackbarView.setFrame(
                            CGRectOffset(
                                snackbarView.frame,
                                0.0,
                                -20.0
                            )
                        ) // Slide up
                    })

                    // Auto-dismiss after 3 seconds
                    NSTimer.scheduledTimerWithTimeInterval(timer, repeats = false) { _ ->
                        UIView.animateWithDuration(0.3, animations = {
                            snackbarView.alpha = 0.0 // Fade out
                        }, completion = { _ ->
                            snackbarView.removeFromSuperview()
                        })
                    }
                }
            }
        }
        @OptIn(ExperimentalForeignApi::class)
        actual fun showToastShort(message: String) {
            invokeToastMessage(message, 1.5)
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun showToastLong(message: String) {
            invokeToastMessage(message, 4.5)
        }
    }
}