plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "fr.mguilbeaud.watchingreading"
    compileSdk = 33

    defaultConfig {
        applicationId = "fr.mguilbeaud.watchingreading"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility(libs.versions.javaVersion.get())
        targetCompatibility(libs.versions.javaVersion.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.javaVersion.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.activityCompose)
    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycleRuntime)
    implementation(libs.compose.ui)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.material3)
    testImplementation(libs.jUnit)
    androidTestImplementation(libs.androidx.test.espressoCore)
    androidTestImplementation(libs.androidx.test.jUnit)
    androidTestImplementation(libs.compose.uiTestJUnit4)
    debugImplementation(libs.compose.uiTooling)
    debugImplementation(libs.compose.uiTestManifest)
}