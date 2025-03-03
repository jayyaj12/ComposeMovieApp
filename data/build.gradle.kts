import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt) // ✅ Hilt 플러그인 적용
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
}

android {
    namespace = "com.aos.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                argument("foo", "bar")
            }
        }

        hilt {
            enableAggregatingTask = false
        }

        val properties = Properties().apply {
            load(rootProject.file("local.properties").inputStream())
        }
        buildConfigField("String", "MOVIE_BASE_URL", "${properties["movie.base.url"]}")
        buildConfigField("String", "MOVIE_API_KEY", "${properties["movie.api.key"]}")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("com.google.dagger:hilt-android:2.55")
    kapt("com.google.dagger:hilt-android-compiler:2.55")
    implementation(libs.timber)
    implementation(libs.hilt.android)
    implementation(libs.retrofit)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}