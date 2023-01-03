pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        id("org.jetbrains.compose").version(extra["compose.version"] as String).apply(false)
        id("com.android.application").version("7.3.0").apply(false)
        id("com.android.library").version("7.3.0").apply(false)
        kotlin("android").version("1.7.20").apply(false)
        kotlin("multiplatform").version("1.7.20").apply(false)
        id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20" apply false
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "FullMultiplatformComposeTest3"
include(":androidApp")
include(":shared")