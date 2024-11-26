plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)

    kotlin("plugin.serialization") version "1.9.22"
}

// Resolve paths during the configuration phase
val fatFrameworkDirProvider = layout.buildDirectory.dir("fat-framework/macos")
val macosX64FrameworkPathProvider = fatFrameworkDirProvider.map { it.dir("macosX64/shared.framework/shared").asFile }
val macosArm64FrameworkPathProvider = fatFrameworkDirProvider.map { it.dir("macosArm64/shared.framework/shared").asFile }
val fatFrameworkOutputDirProvider = fatFrameworkDirProvider.map { it.dir("shared.framework").asFile }

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    // Configure iOS targets
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    // Configure macOS targets
    listOf(
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            outputDirectory = fatFrameworkDirProvider.get().dir(it.name).asFile
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val macosMain by creating {
            dependencies {
                // Add macOS-specific dependencies if required
            }
        }
    }
}

tasks.register("assembleDebugFrameworkForMacos") {
    dependsOn("linkDebugFrameworkMacosX64", "linkDebugFrameworkMacosArm64")

    // Resolve paths in the configuration phase
    val macosX64FrameworkPath = macosX64FrameworkPathProvider.get()
    val macosArm64FrameworkPath = macosArm64FrameworkPathProvider.get()
    val fatFrameworkOutputDir = fatFrameworkOutputDirProvider.get()

    doLast {
        // Ensure the output directory exists
        fatFrameworkOutputDir.mkdirs()

        // Merge the frameworks using `lipo`
        exec {
            commandLine(
                "lipo",
                "-create",
                "-output",
                fatFrameworkOutputDir.resolve("shared").absolutePath,
                macosX64FrameworkPath.absolutePath,
                macosArm64FrameworkPath.absolutePath
            )
        }

        // Copy additional framework files from macosX64 to the output
//        copy {
//            from(fatFrameworkDirProvider.get().dir("macosX64/shared.framework"))
//            into(fatFrameworkOutputDir)
//            exclude("shared")
//        }
    }
}

android {
    namespace = "com.architect.testclient"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}