plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
}

allprojects{
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