<br/>
<p align="center">
    <a href="https://github.com/TheArchitect123/TitanSocket"><img src="./kotlin.jpg" align="center" width=350/></a>
</p>

<p align="center">
An essentials library for Kotlin multiplatform that makes it easier to work with anything. Supports iOS & Android.
    <br/>
<strong>Currently only 12.3 kB in size</strong>

</p>
<br/>

<p align="center">
   <a href="https://central.sonatype.com/artifact/io.github.thearchitect123/kmpEssentials">
    <img alt="GitHub" src="https://img.shields.io/maven-central/v/io.github.thearchitect123/kmpEssentials">
  </a>

  <a href="https://github.com/TheArchitect123/kmpEssentials">
    <img alt="GitHub" src="https://img.shields.io/badge/_Android,_iOS-white.svg">
  </a>
</p

<br/>

## How it works

KmpEssentials is a library that contains apis to accelerate your development. Everything from managing the Battery, File System, or getting Package information. 

To get started, import the library into your project:

```sh
implementation("io.github.thearchitect123:kmpEssentials:0.3.8")
```
## Setup for Android

In your Activity's **onCreate** add the below to initialize the framework.
```sh
 override onCreate(savedInstanceBundle: Bundle?) {
     KmpAndroid.initializeApp(this) {
         // optional action to invoke for any permissions disabled by the user. 
         // Used only by the internal permissions module. 
         // You can present a toast message or any error popup of some kind.
    }
 }
```

<strong>A comprehensive documentation site for each API is in development.</strong>
However for now, below is a small snippet that explains how to use each module. <strong> The concept is the same for all modules. </strong>

<br/>
<br/>
To access and use each module you must use the static component belonging to each module.
<br/>ComponentModule.functionToInvoke()

<br/>
<br/>
So as an example, Here we are going to activate the device's accelerometer to fetch X,Y,Z axes data, and pass it into our app
To subscribe to changes to the device's orientation, we invoke the <strong>startListening</strong> function. We can then process the results in our app.
<br/>

```sh
KmpAccelerometer.startListening { 
     val x = it.first
     val y = it.second
     val z = it.third
}
```

To stop listening to acc changes, we use the function stopListening. It's important to deactivate the listener, so the component doesn't continue to broadcast acc data changes to our app. 
```sh
KmpAccelerometer.stoplistening()
```

Below is a list of all modules, along with what each of them do.
<br/>
<br/>
<strong>KmpAccelerometer</strong> - Used for fetching Accelerometer Data from your device (X,Y,Z Axes)
<br/>
<strong>KmpAlert</strong> - Used for rendering Alert Popups, and prompting confirmation from the user
<br/>
<strong>KmpAppInfo</strong> - Use this for fetching information about your app (Package Name, Version, Configured App Theme, etc)
<br/>
<strong>KmpBackgrounding </strong> - Use this for running a background worker, to run your action in the background
<br/>
<strong>KmpBattery </strong> - Use this for fetching Battery State information, Current Charge, and Charge source for your device
<br/>
<strong>KmpBiometrics </strong> - Used for Biometric Authentication (Fingerprint Scanning & Facial Detection)
<br/>
<strong>KmpCamera </strong> - Use this for taking photos either from the camera or photo gallery
<br/>
<strong>KmpClipboard </strong> - Use this for copying/fetching texts from your device's clipboard
<br/>
<strong>KmpConnectivity </strong> - Manage your device's connectivity state, listen to network connectivity changes, gets network name
<br/>
<strong>KmpContacts </strong> - Manages all Contacts Api for your Device (Fetches a Full list of Contacts, or allows a user to select a single Contact)
<br/>
<strong>KmpDeviceDisplay </strong> - Use this to manage your device's screen and display behavior
<br/>
<strong>KmpDeviceInfo</strong> - Gets device runtime information (Checks if running on Android or iOS), returns device timezone, etc
<br/>
<strong>KmpEmail</strong> - Managing and sending emails
<br/>
<strong>KmpFilePicker</strong> - Picks files from local storage (single File, or Multiple Files)
<br/>
<strong>KmpFileSystem </strong> - Fetches information about the File System (app directory, temp cache directory, create/delete files, etc)
<br/>
<strong>KmpFlashlight </strong> - Manages the device's flashlight (toggles ON/OFF), adjust brightness, etc
<br/>
<strong>KmpGeolocation </strong> - Fetch user's current location (requires Location Permissions Set)
<br/>
<strong>KmpGyroscope </strong> - Used for fetching Gyroscope Data from your device (X,Y,Z Axes)
<br/>
<strong>KmpLauncher</strong> - Launch urls via web browser, launch Google/Apple maps with address/coordinates, launch maps directions with the given address
<br/>
<strong>KmpLocalNotifications </strong> - Broadcasts local notifications using the title & message specified
<br/>
<strong>KmpMagnometer </strong> - Used for fetching magnetometer Data from your device (X,Y,Z Axes)
<br/>
<strong>KmpMainThread </strong> - Run any action inside the main thread.
<br/>
<strong>KmpOrientationManager</strong> - Listens to orientation changes, get current orientation for device (Portrait/Landscape)
<br/>
<strong>KmpPermissionsManager</strong> - Request runtime permissions, check if permission has been granted
<br/>
<strong>KmpProximity </strong> - Used for checking if an object is close to your device's proximity sensor
<br/>
<strong>KmpScreenshot </strong> - Takes a screenshot of your screen, saves to your photo album, and returns the Url
<br/>
<strong>KmpSecureStorage </strong> - 
 * Writes to a public storage <br/>
 * For Android: Writes to Encrypted Text Shared Preferences<br/>
 * For iOS: Writes to Keychain Service <br/>
<br/>
<strong>KmpPublicStorage </strong> -
 * Writes to a public storage<br/>
 * For Android: Writes to Clear Text Shared Preferences<br/>
 * For iOS: Writes to NSUserDefaults <br/>
<br/>
<strong>KmpShare </strong> - Share text, or a file with the device's Sharing System (IntentChooser for Android, iOS ActivityViewController)
<br/>
<strong>KmpSms </strong> - Sends an Sms via the device's internal messaging app
<br/>
<strong>KmpTelecom </strong> - Manage telecoms, opens the phone dialer app with the specified mobile number
<br/>
<strong>KmpTextToSpeech </strong> - TextToSpeech Services, converts text to Speech, and microphone based Speech to Text
<br/>
<strong>KmpVibration </strong> - Run a device vibration for a specified duration, stop a vibration
<br/>
## License

This software is licensed under the MIT license. See [LICENSE](./LICENSE) for full disclosure.
