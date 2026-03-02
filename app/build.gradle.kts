plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.notesapp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding  = true
    }
    defaultConfig {
        applicationId = "com.example.notesapp"
        minSdk = 24
        targetSdk = 36
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Source: https://mvnrepository.com/artifact/com.intuit.sdp/sdp-android
    runtimeOnly(libs.sdp.android)

    // Source: https://mvnrepository.com/artifact/com.intuit.ssp/ssp-android
    runtimeOnly(libs.ssp.android)
}