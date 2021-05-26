import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream
import java.io.FileNotFoundException

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

var versionMajor: Int = 0
var versionMinor: Int = 0
var versionBuild: Int = 0
var versionsPropsFile = file("versions.properties")

if (versionsPropsFile.canRead()) {
    val properties = Properties()
    properties.load(FileInputStream(versionsPropsFile))
    versionMajor = properties.getProperty("versionMajor").toInt()
    versionMinor = properties.getProperty("versionMinor").toInt()
    versionBuild = properties.getProperty("versionBuild").toInt()
} else {
    throw FileNotFoundException("Could not read versions.properties!")
}

android {
    compileSdkVersion(Core.compile_sdk_version)
    buildToolsVersion(Core.build_tools_version)

    defaultConfig {
        applicationId = "rs.myexample.hilt"
        minSdkVersion(Core.min_sdk_version)
        targetSdkVersion(Core.target_sdk_version)
        versionCode = (System.currentTimeMillis() / 1000).toInt()
        versionName = "$versionMajor.$versionMinor.$versionBuild"
        multiDexEnabled = true
        testInstrumentationRunner = Core.android_junit_runner
    }

    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }

    flavorDimensions("Hilt")
    productFlavors {
        create("development") {
            versionName = "${versionMajor}.${versionMinor}.${versionBuild}"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            buildConfigField("String", "BASE_URL", "\"${BuildConfig.base_url}\"")
        }
        create("production") {
            versionName = "${versionMajor}.${versionMinor}.${versionBuild}"
            buildConfigField("String", "BASE_URL", "\"${BuildConfig.base_url}\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.core_ktx)
    implementation(Libs.app_compat)
    implementation(Libs.constraint_layout)
    implementation(Libs.recycler_view)
    implementation(Libs.lifecycle_viewmodel)
    implementation(Libs.lifecycle_live_data)
    implementation(Libs.activity_ktx)
    implementation(Libs.hilt_android)
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_gson_converter)
    implementation(Libs.gson)
    implementation(Libs.okhttp)
    implementation(Libs.okhttp_logging_interceptor)
    implementation(Libs.coroutines_android)
    implementation(Libs.coroutines_core)
    implementation(Libs.lifecycle_common_java8)
    implementation(Libs.timber_lib)
    implementation(Libs.lifecycle_runtime)
    implementation(Libs.paging_runtime)
    implementation(Libs.navigation_fragment)
    implementation(Libs.navigation_ui)
    implementation(Libs.room_runtime)
    implementation(Libs.room_ktx)
    kapt(Libs.room_compiler)
    annotationProcessor(Libs.room_compiler)
    kapt(Libs.hilt_android_compiler)
    kapt(Libs.lifecycle_compiler)
    kapt(Libs.hilt_androidx_compiler)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.espresso)
}