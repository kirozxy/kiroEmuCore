plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    kotlinOptions {
        jvmTarget = "17"
    }
    namespace = "com.kirozxy.emulator.cores"
}

dependencies {
    implementation(kotlin(deps.libs.kotlin.stdlib))
}
