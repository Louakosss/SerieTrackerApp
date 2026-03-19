plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false  // N'est plus rouge maintenant !
    alias(libs.plugins.kotlin.compose) apply false

    // Hilt et KSP
    id("com.google.dagger.hilt.android") version "2.57.1" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.28" apply false
}