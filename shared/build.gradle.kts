import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.22"

    id("org.gradle.maven-publish")
    id("signing")
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.28.0"
    id("io.github.ttypic.swiftklib")
}

kotlin {
    kotlin.applyDefaultHierarchyTemplate()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
//        it.compilations {
//            val main by getting {
//                cinterops {
//                    create("SwiftEssentialsEngine")
//                }
//            }
//        }
        it.binaries.framework {
            baseName = "shared"
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

        publishLibraryVariants("release")
    }

    // watchOS (Apple)
    watchosArm64()
    watchosArm32()
    watchosX64()
    watchosSimulatorArm64()

    // tvos (Apple)
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    // java target
    //jvm()

    //mac & desktop targets
    macosX64()
    macosArm64()
//
    linuxX64()
    linuxArm64()
//
    mingwX64()

    // browser
    //js().browser()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("co.touchlab:kermit:2.0.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
            }
        }

        // windows desktop target
        val mingwMain by getting {
            dependsOn(commonMain)
        }
        val mingwX64Main by getting {
            dependsOn(mingwMain)
        }

        // linux
        val linuxMain by getting {
            dependsOn(commonMain)
        }
        val linuxX64Main by getting {
            dependsOn(linuxMain)
        }
        val linuxArm64Main by getting {
            dependsOn(linuxMain)
        }

        // watch os target
        val watchosMain by getting {
            dependsOn(commonMain)
        }
        val watchosX64Main by getting {
            dependsOn(watchosMain)
        }
        val watchosArm32Main by getting {
            dependsOn(watchosMain)
        }
        val watchosArm64Main by getting {
            dependsOn(watchosMain)
        }
        val watchosSimulatorArm64Main by getting {
            dependsOn(watchosMain)
        }

        // macos main
        val macosMain by getting {
            dependsOn(commonMain)
        }
        val macosX64Main by getting {
            dependsOn(macosMain)
        }
        val macosArm64Main by getting {
            dependsOn(macosMain)
        }

        // tvos targets
        val tvosMain by getting {
            dependsOn(commonMain)
        }
        val tvosX64Main by getting {
            dependsOn(tvosMain)
        }
        val tvosArm64Main by getting {
            dependsOn(tvosMain)
        }
        val tvosSimulatorArm64Main by getting {
            dependsOn(tvosMain)
        }

        // android & iOS targets
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("dev.tmapps:konnection:1.4.1")
                implementation("com.liftric:kvault:1.12.0")

                implementation("androidx.preference:preference:1.2.1")
                implementation("com.google.android.material:material:1.12.0")
                implementation("androidx.biometric:biometric:1.1.0")
                implementation("androidx.activity:activity-ktx:1.9.1")
                implementation("io.github.chochanaresh:filepicker:0.2.5")
                implementation("androidx.appcompat:appcompat:1.7.0")
                implementation("androidx.startup:startup-runtime:1.1.1")
                implementation("androidx.core:core-ktx:1.13.1")
                implementation("androidx.work:work-runtime-ktx:2.9.1")
                implementation("com.google.android.gms:play-services-location:21.3.0")
                implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
                implementation(libs.androidx.lifecycle.process)
            }
        }

        // iOS Targets
        val iosArm64Main by getting
        val iosX64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("dev.tmapps:konnection:1.4.1")
                implementation("com.liftric:kvault:1.12.0")
            }
        }
    }
}

afterEvaluate {
    mavenPublishing {
        // Define coordinates for the published artifact
        coordinates(
            groupId = "io.github.thearchitect123",
            artifactId = "kmpEssentials",
            version = "1.4.8"
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

swiftklib {
    create("SwiftEssentialsEngine") {
        path = file("native/SwiftEssentialsEngine")
        packageName("com.ttypic.objclibs.swiftEssentialsEngine")
    }
}