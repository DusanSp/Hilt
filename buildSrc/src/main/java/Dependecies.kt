object BuildConfig {
    const val base_url = "https://reqres.in/api/"
}

object Core {
    const val compile_sdk_version = 29
    const val min_sdk_version = 21
    const val target_sdk_version = 29
    const val build_tools_version = "29.0.3"
    const val android_junit_runner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val kotlin_version = "1.5.0"
    const val android_core = "1.3.2"
    const val appcompat = "1.2.0"
    const val constraint_layout = "2.0.1"
    const val junit = "4.12"
    const val espresso_core = "3.3.0"
    const val com_android_tools_build_gradle = "4.2.1"
    const val kotlin_gradle_plugin = "1.5.0"
    const val recycler_view = "1.2.0"
    const val lifecycle_version = "2.3.1"
    const val activity_version = "1.1.0"
    const val hilt = "2.35.1"
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"
    const val okhttp = "4.9.0"
    const val coroutines = "1.4.2"
    const val androidx_hilt = "1.0.0"
    const val timber = "4.7.1"
    const val build_gradle = "4.1.0"
    const val paging = "3.0.0"
    const val version = "0.36.0"
    const val nav_version = "2.3.3"
    const val room_version = "2.3.0"
    /**
     * Current version: "6.1.1"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleVersion: String = "4.2.0"
}

object Libs {
    // kotlin
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    // Core
    const val core_ktx = "androidx.core:core-ktx:${Versions.android_core}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_version}"
    // Lifecycle
    const val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_live_data =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycle_compiler =
        "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
    const val lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle_version}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    // Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_androidx_compiler = "androidx.hilt:hilt-compiler:${Versions.androidx_hilt}"
    // Networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    // Coroutines
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    // Logging
    const val timber_lib = "com.jakewharton.timber:timber:${Versions.timber}"
    // Paging
    const val paging_runtime = "androidx.paging:paging-runtime:${Versions.paging}"
    // Room
    const val room_runtime = "androidx.room:room-runtime:${Versions.room_version}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room_version}"
}

object ClassPath {
    const val com_android_tools_build_gradle =
        "com.android.tools.build:gradle:${Versions.com_android_tools_build_gradle}"
    const val kotlin_gradle_plugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin}"
    const val hilt_android_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val tools_build_gradle = "com.android.tools.build:gradle:${Versions.build_gradle}"
    const val versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.version}"
}