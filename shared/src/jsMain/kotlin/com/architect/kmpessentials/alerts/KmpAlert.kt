package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.aliases.DefaultAction
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLDivElement


actual class KmpAlert {
    actual companion object {
        actual fun showAlert(message: String, title: String) {
            kotlinx.browser.window.alert("$title\n\n$message")
        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction,
        ) {
            val result = kotlinx.browser.window.confirm("$title\n\n$message")
            if (result) {
                okAction()
            }
        }

        actual fun showAlertWithTertiaryButtonsConfirmation(
            message: String,
            title: String,
            okText: String,
            secondaryText: String,
            cancelText: String,
            okAction: DefaultAction,
            secondaryAction: DefaultAction
        ) {
            val result = window.confirm("$title\n\n$message")
            if (result) {
                okAction()
            }
        }

        actual fun showAlertWithConfirmation(
            message: String,
            title: String,
            okText: String,
            cancelText: String,
            okAction: DefaultAction,
            cancelAction: DefaultAction
        ) {
            // Create a custom alert container
            val alertBox = document.createElement("div") as HTMLDivElement
            alertBox.innerHTML = """
        <div id="custom-alert" style="
            position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);
            background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 0px 10px rgba(0,0,0,0.3);
            min-width: 300px; text-align: center; font-family: Arial, sans-serif;">
            <h2 style="margin: 0; padding: 10px 0; font-size: 18px;">$title</h2>
            <p style="padding: 10px 0;">$message</p>
            <button id="ok-button" style="background: #007BFF; color: white; border: none; padding: 10px;
                    border-radius: 5px; cursor: pointer; margin-right: 10px;">
                OK
            </button>
            <button id="cancel-button" style="background: red; color: white; border: none; padding: 10px;
                    border-radius: 5px; cursor: pointer;">
                Cancel
            </button>
        </div>
    """.trimIndent()

            document.body?.appendChild(alertBox)

            // Add click event listeners for buttons
            document.getElementById("ok-button")?.addEventListener("click", {
                document.body?.removeChild(alertBox)
                okAction()
            })

            document.getElementById("cancel-button")?.addEventListener("click", {
                document.body?.removeChild(alertBox)
                cancelAction()
            })
        }
    }
}