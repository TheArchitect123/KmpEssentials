package com.architect.kmpessentials.launcher

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.CoreLocation.CLGeocoder
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.CoreLocation.CLPlacemark
import platform.Foundation.NSURL
import platform.MapKit.MKLaunchOptionsDirectionsModeDriving
import platform.MapKit.MKLaunchOptionsDirectionsModeKey
import platform.MapKit.MKMapItem
import platform.MapKit.MKPlacemark
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

@OptIn(ExperimentalForeignApi::class)
actual class KmpLauncher {
    actual companion object {

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {
            dispatch_async(dispatch_get_main_queue()) {
                val geocoder = CLGeocoder()
                geocoder.geocodeAddressString(address) { result, error ->
                    val coordinates = result?.firstOrNull()
                    if (coordinates != null) {
                        (coordinates as CLPlacemark).location?.coordinate?.useContents {
                            launchExternalMapsAppWithCoordinates(latitude, longitude)
                        }
                    }
                }
            }
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            dispatch_async(dispatch_get_main_queue()) {
                val placemark =
                    MKPlacemark(coordinate = CLLocationCoordinate2DMake(latitude, longitude))
                val mapItem = MKMapItem(placemark = placemark)
                val launchOptions =
                    mapOf<kotlin.Any?, String>(MKLaunchOptionsDirectionsModeKey to MKLaunchOptionsDirectionsModeDriving)
                mapItem.openInMapsWithLaunchOptions(launchOptions)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            openExternalLink(linkPath)
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            openExternalLink(linkPath)
        }

        private fun openExternalLink(linkPath: String) {
            val link = NSURL.URLWithString(linkPath)!!
            if (UIApplication.sharedApplication.canOpenURL(link)) {
                UIApplication.sharedApplication.openURL(link)
            }
        }

        actual fun launchAppInternalSettings() {
            UIApplication.sharedApplication.openURL(
                NSURL.URLWithString(
                    UIApplicationOpenSettingsURLString
                )!!
            )
        }
    }
}