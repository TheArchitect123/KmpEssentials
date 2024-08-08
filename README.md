<br/>
<p align="center">
    <a href="https://github.com/TheArchitect123/TitanSocket"><img src="./kotlin.jpg" align="center" width=350/></a>
</p>

<p align="center">
An essentials library for Kotlin multiplatform that makes it easier to work with anything. Supports iOS & Android

</p>
<br/>

<p align="center">
   <a href="https://central.sonatype.com/artifact/io.github.thearchitect123/titansocket">
    <img alt="GitHub" src="https://img.shields.io/maven-central/v/io.github.thearchitect123/titansocket.svg">
  </a>

  <a href="https://github.com/TheArchitect123/TitanSocket">
    <img alt="GitHub" src="https://img.shields.io/badge/targets-JVM,_Android,_iOS-white.svg">
  </a>
</p


## How it works
KmpEssentials is a library that contains apis to accelerate your development. Everything from managing the Battery, File System, or getting Package information. 

To get started, import the library into your project:

```sh
implementation("io.github.thearchitect123:kmpEssentials:0.1.5")
```
## Setup for Android
```sh
 override onCreate(savedInstanceBundle: Bundle?) {
     KmpAndroid.clientAppContext = this
 }
```

Make sure to view the documentation here.


## License

This software is licensed under the MIT license. See [LICENSE](./LICENSE) for full disclosure.
