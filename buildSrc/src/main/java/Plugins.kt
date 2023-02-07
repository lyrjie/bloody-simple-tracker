object Plugins {

    object Project {
        object Classpath {
            const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
            const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
            const val firebaseCrashlytics =
                "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradlePlugin}"
        }

        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinSerialization = "plugin.serialization"
        const val dependencyChecker = "name.remal.check-dependency-updates"
    }

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val gitVersioning = "com.gladed.androidgitversion"
    const val kotlinKapt = "kotlin-kapt"
    const val ksp = "com.google.devtools.ksp"
    const val hilt = "dagger.hilt.android.plugin"
    const val googleServices = "com.google.gms.google-services"
    const val firebaseCrashlytics = "com.google.firebase.crashlytics"
}
