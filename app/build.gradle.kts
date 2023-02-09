@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)

    id(Plugins.kotlinKapt)
    id(Plugins.ksp) version Versions.ksp
    id(Plugins.hilt)

    id(Plugins.googleServices)
    id(Plugins.firebaseCrashlytics)

    id(Plugins.Project.dependencyChecker) version Versions.dependencyChecker
    id(Plugins.gitVersioning) version Versions.gitVersioning
}

androidGitVersion {
    format = "%tag%"
}

android {
    namespace = "com.lyrjie.bloodysimpletracker"

    compileSdk = 33

    val isBuildLocal = System.getenv("CI") == null
    setBuildOutputPath(isBuildLocal)
    val generatedVersionCode = androidGitVersion.code()
    val generatedVersionName = androidGitVersion.name().split("/").first()
    println("Generated Version Code: $generatedVersionCode")
    println("Generated Version Name: $generatedVersionName")

    signingConfigs {
        create(signingConfigName) {
            val localProperties = gradleLocalProperties(rootDir)
            storeFile = file("../keystore.jks")
            storePassword = localProperties.getProperty("keystore.password")
            keyAlias = localProperties.getProperty("keystore.keyAlias")
            keyPassword = localProperties.getProperty("keystore.password")
        }
    }

    defaultConfig {
        applicationId = "com.lyrjie.bloodysimpletracker"
        minSdk = 21
        targetSdk = 33
        versionCode = generatedVersionCode
        versionName = generatedVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        if (isComposeProject) {
            vectorDrawables {
                useSupportLibrary = true
            }
        }
        if (isRoomEnabled) {
            javaCompileOptions {
                annotationProcessorOptions {
                    argument("room.schemaLocation", "$projectDir/schemas")
                }
            }
        }
    }

    buildTypes {
        create(AppBuildType.Qa.name) {
            isMinifyEnabled = true
        }

        release {
            isMinifyEnabled = true
        }

        all {
            signingConfig = signingConfigs.getByName(signingConfigName)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        forEach {
            val buildType = AppBuildType.getByName(it.name)

            if (buildType != AppBuildType.Release) {
                it.applicationIdSuffix = ".${buildType.name}"
                it.versionNameSuffix = " ${buildType.name}"
                it.resValue("string", Keys.APP_NAME, "$appName ${buildType.name}")
            } else {
                it.resValue("string", Keys.APP_NAME, appName)
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    if (isComposeProject) {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.composeCompiler
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    coreLibraryDesugaring(Dependencies.desugaring)

    implementation(Dependencies.androidCore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.activity)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    if (isComposeProject) {
        implementation(Dependencies.composeCompiler)
        implementation(platform(Dependencies.composeBom))
        implementation(Dependencies.composeUi)
        implementation(Dependencies.composeMaterial)
        implementation(Dependencies.composeMaterial3)
        implementation(Dependencies.composePreview)

        implementation(Dependencies.accompanistSystemUi)
    }

    implementation(Dependencies.coroutines)

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    implementation(Dependencies.timber)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseCrashlytics)

    if (isRoomEnabled) {
        implementation(Dependencies.roomRuntime)
        implementation(Dependencies.roomKotlinExt)
        ksp(Dependencies.roomCompiler)
    }

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.espresso)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    // Fix from https://youtrack.jetbrains.com/issue/KT-55565/Consider-de-duping-or-blocking-standard-addition-of-freeCompilerArgs-to-KaptGenerateStubsTask
    val isKaptGenerateStubsTask = this is org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask
    if (!isKaptGenerateStubsTask) {
        kotlinOptions.freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                    "${project.buildDir.absolutePath}/composeMetrics"
        )
        kotlinOptions.freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                    "${project.buildDir.absolutePath}/composeMetrics"
        )
    }
}

fun com.android.build.gradle.internal.dsl.BaseAppModuleExtension.setBuildOutputPath(isBuildLocal: Boolean) {
    applicationVariants.all {
        outputs.all {
            val variant = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            if (!isBuildLocal) variant.outputFileName = "../../../../../app.apk"
        }
    }
}

fun com.android.build.api.dsl.ApplicationBuildType.setStringField(key: String, value: String) {
    buildConfigField("String", key, "\"$value\"")
}
