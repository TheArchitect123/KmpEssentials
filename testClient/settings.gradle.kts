enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "testClient"
include(":androidApp")
include(":shared")


include(":kmpEssentials")
project(":kmpEssentials").projectDir = File("../shared")
