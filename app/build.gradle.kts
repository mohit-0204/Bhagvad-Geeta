plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization) // ✅ Serialization plugin
    alias(libs.plugins.dagger.hilt) // ✅ Hilt plugin
    alias(libs.plugins.ksp) // ✅ KSP plugin
    alias(libs.plugins.google.services) // ✅ Google-Services plugin

}

android {
    namespace = "com.mxverse.bhagvadgeeta"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mxverse.bhagvadgeeta"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    hilt {
        enableAggregatingTask = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ✅ Navigation for Jetpack Compose
    implementation(libs.androidx.navigation.compose)

    // ✅ Hilt for Dependency Injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose) // if using Hilt Navigation Compose

    // ✅ Lifecycle ViewModel in Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // ✅ Room Database
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // ✅ WorkManager for background scheduling
    implementation(libs.work.runtime.ktx)

    // ✅ Retrofit & Gson for networking
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // ✅ Kotlin Serialization (alternative to Gson && used for type safe Navigation)
    implementation(libs.kotlinx.serialization.json)

    // ✅ Coil for image loading
    implementation(libs.coil.compose)
    implementation(libs.coil.okhttp)

    // ✅ Logging Interceptor for HTTP requests
    implementation(libs.okhttp.logging)

    // ✅ Firebase Dependencies for backend
    implementation(platform(libs.firebase.bom)) // BOM ensures versions match
    implementation(libs.firebase.auth)


}