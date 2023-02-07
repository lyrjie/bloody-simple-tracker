plugins {
    id(Plugins.Project.androidApplication) version Versions.gradleAndroidPlugin apply false
    id(Plugins.Project.androidLibrary) version Versions.gradleAndroidPlugin apply false
    id(Plugins.Project.kotlinAndroid) version Versions.kotlin apply false
    id(Plugins.Project.dependencyChecker) version Versions.dependencyChecker
}

buildscript {
    dependencies {
        classpath(Plugins.Project.Classpath.googleServices)
        classpath(Plugins.Project.Classpath.firebaseCrashlytics)
        classpath(Plugins.Project.Classpath.hilt)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
