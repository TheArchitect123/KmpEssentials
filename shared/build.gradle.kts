import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.22"

    id("org.gradle.maven-publish")
    id("signing")
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

kotlin {
    targetHierarchy.default()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

        publishLibraryVariants("release", "debug")
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "13.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.biometric:biometric:1.1.0")
                implementation("androidx.activity:activity-ktx:1.9.1")
                implementation("io.github.chochanaresh:filepicker:0.2.5")
                implementation("androidx.appcompat:appcompat:1.7.0")
                implementation("com.github.michael-winkler:Screenshot:1.0.0")
                implementation("androidx.startup:startup-runtime:1.1.1")
                implementation("androidx.core:core-ktx:1.13.1")
                implementation("androidx.work:work-runtime-ktx:2.9.1")
                implementation("com.google.android.gms:play-services-location:21.3.0")
                implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
                implementation("androidx.activity:activity-compose:1.9.1")
            }
        }

        // iOS Targets
        val iosMain by getting {
            dependsOn(commonMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

afterEvaluate {
    mavenPublishing {
        // Define coordinates for the published artifact
        coordinates(
            groupId = "io.github.thearchitect123",
            artifactId = "kmpEssentials",
            version = "0.3.5"
        )

        // Configure POM metadata for the published artifact
        pom {
            name.set("KmpEssentials")
            description.set("An essentials library for Kotlin multiplatform that makes it easy to work with any native apis from your shared business logic. Supports iOS & Android")
            inceptionYear.set("2024")
            url.set("https://github.com/TheArchitect123/KmpEssentials")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }

            // Specify developers information
            developers {
                developer {
                    id.set("Dan Gerchcovich")
                    name.set("TheArchitect123")
                    email.set("dan.developer789@gmail.com")
                }
            }

            // Specify SCM information
            scm {
                url.set("https://github.com/TheArchitect123/KmpEssentials")
            }
        }

        // Configure publishing to Maven Central
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

        // Enable GPG signing for all publications
        signAllPublications()
    }
}

android {
    namespace = "io.github.thearchitect123"
    compileSdk = libs.versions.droidCompileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.droidMinSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}