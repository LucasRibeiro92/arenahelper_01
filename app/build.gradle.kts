plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = "com.scout.arenahelper_01"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.scout.arenahelper_01"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /*
    *
    * Firebase
    *
    */
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    //Auth
    implementation("com.firebaseui:firebase-ui-auth:7.2.0")

    /*
    *
    * Lifecycle
    *
    */
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    /*
    *
    * Koin
    *
    */
    implementation("io.insert-koin:koin-android:3.2.0")
    implementation("io.insert-koin:koin-android-compat:3.2.0")
    implementation("io.insert-koin:koin-androidx-compose:3.4.5")

    /*
    *
    * Room
    *
    */
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-testing:2.5.1")

    /*
    *
    * Glide
    *
    */
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")
}