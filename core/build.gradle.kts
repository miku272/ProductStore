plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.nareshsharma.core"
    ndkVersion = "30.0.15729638"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }

}

dependencies {
    // Standard Android/Kotlin libs
    api(libs.androidx.core.ktx)

    // Jetpack Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.icons.core)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.hilt.lifecycle.viewmodel.compose)
    api(libs.androidx.navigation.compose)

    // Dependency Injection (Hilt)
    api(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Network & Serialization
    api(libs.retrofit)
    api(libs.retrofit.converter.kotlinx.serialization)
    api(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging.interceptor)

    // Image Loading (Coil)
    api(libs.coil.compose)
    api(libs.coil.network.okhttp)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(libs.androidx.compose.ui.tooling)
}