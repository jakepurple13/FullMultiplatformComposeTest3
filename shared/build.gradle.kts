plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("kotlinx-serialization")
}

kotlin {
    android()
    ios()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val ktorVersion = "2.2.1"
        val composeVersion = extra["compose.version"] as String
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.compose.runtime:runtime:$composeVersion")
                api("org.jetbrains.compose.ui:ui:$composeVersion")
                api("org.jetbrains.compose.foundation:foundation:$composeVersion")
                api("org.jetbrains.compose.material:material-icons-extended:$composeVersion")
                api("org.jetbrains.compose.material:material:$composeVersion")
                //api(compose.material3)
                api("io.ktor:ktor-client-core:$ktorVersion")
                /*api("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")*/
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        val androidTest by getting
        val iosMain by getting {
            dependencies {
                api("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        /*val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }*/
    }
}

android {
    namespace = "com.programmersbox.fullmultiplatformcomposetest3"
    compileSdk = 33
    defaultConfig {
        minSdk = 23
        targetSdk = 33
    }
}