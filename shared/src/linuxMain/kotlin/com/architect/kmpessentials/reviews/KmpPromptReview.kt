package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpPromptReview {
    actual companion object {
        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {

        }

        actual fun promptReviewViaExternal() {

        }

        actual fun openAppStoreLink() {

        }
    }
}