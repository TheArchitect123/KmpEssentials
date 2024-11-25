import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
//    macosX64()
//    macosArm64()

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "17" // Ensure compatibility with the latest JVM version
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        commonMain.dependencies {
            implementation(projects.kmpEssentials)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
        desktopMain.dependencies {
            implementation(projects.kmpEssentials)
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }

//        val macosMain by creating {
//            dependencies {
//                //implementation(projects.commonMain) // Shared module
//
//            }
//        }
    }
}


compose.desktop {
    application {
        mainClass = "org.example.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
