plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
}

allprojects{
//    tasks.withType<DokkaTask>().configureEach{
//        outputDirectory = buildDir.resolve("dokka")
//    }

    plugins.withId("com.android.library") {
        configure<com.android.build.gradle.LibraryExtension> {
            compileSdkVersion(libs.versions.droidCompileSdk.get().toInt())

            defaultConfig {
                minSdkVersion(libs.versions.droidMinSdk.get().toInt())
                targetSdkVersion(libs.versions.droidTargetSdk.get().toInt())
            }
        }
    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}