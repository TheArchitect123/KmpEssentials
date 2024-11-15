package com.architect.kmpessentials.launcher

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturnAsync

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KmpLauncher {
    companion object {
        /**
         * Starts a native timer that reruns your action ONCE with the specified delay
         * @param seconds the delay to use between loops (for your action).
         * */
        fun startTimer(seconds: Double, action: DefaultActionWithBooleanReturn)

        /**
         * Starts a native timer that reruns your action with the specified delay. Continues Looping and reruns the action, until you return False
         * Return True only if the Timer Loop needs to be closed.
         * @param seconds the delay to use between loops (for your action). Example, if specifying One Second = Run Action Every Second (AND LOOPS, UNTIL RETURNS FALSE)
         * */
        fun startTimerRepeating(seconds: Double, action: DefaultActionWithBooleanReturn)

        /**
         * Launches the native maps app with directions. Navigates the user to address.
         * @param address the full address to direct the user to
         * */
        fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String = ""
        )

        /**
         * Launches the native maps app with directions.
         * @param latitude Latitude of the Address
         * @param longitude Longitude of the address
         * */
        fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String = ""
        )

        /**
         * Launches an external Url with the device's browser
         * @param linkPath the Url to navigate to
         * */
        fun launchExternalUrlViaBrowser(linkPath: String)

        /**
         * Launches an external Url with an app of the user's choice. On Android, launches an Intent Chooser
         * @param linkPath the Url to navigate to
         * */
        fun launchExternalUrlViaAnyApp(linkPath: String)

        /**
         * Launches device's internal settings app
         * */
        fun launchAppInternalSettings()

        /**
         * Launches app via app store Link (iOS requires an app store Identifier to work)
         * */
        fun launchAppStoreViaIdentifier(appStoreLink: String)
    }
}