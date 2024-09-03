plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.reservecarwash_mobile_android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.reservecarwash_mobile_android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"



        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.google.android.gms:play-services-maps:17.0.1")
    implementation("com.android.support:recyclerview-v7:28.0.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation ("androidx.viewpager:viewpager:1.0.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.hbb20:ccp:2.7.0")
    implementation ("com.googlecode.libphonenumber:libphonenumber:8.12.35")
    implementation ("me.drozdzynski.library.steppers:steppers:1.0.0")
    implementation ("com.github.f0ris.sweetalert:library:1.5.6")


}