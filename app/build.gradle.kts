plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.appId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
        unitTests.isIncludeAndroidResources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources.pickFirsts += "/META-INF/AL2.0"
        resources.pickFirsts += "/META-INF/LGPL2.1"
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":usecases"))
    implementation(project(":testShared"))

    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.appCompanist)
    implementation(Deps.material)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composePreview)
    implementation(Deps.lifecycleKtx)
    implementation(Deps.activity)

    testImplementation(Deps.jUnitImplementation)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    testImplementation(Deps.mockito)
    testImplementation(Deps.mockitoInline)
    testImplementation(Deps.testCoroutines)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.composeJUnit)
    debugImplementation(Deps.composeTooling)

    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)

    implementation(Deps.retrofit)
    implementation(Deps.retrofitSerialization)
    implementation(Deps.retrofitTickXml)
    implementation(Deps.tickXmlCore)
    implementation(Deps.tickXmlConverter)
    implementation(Deps.tickXmlAnnotation)
    kapt(Deps.tickXmlKapt)

    implementation(Deps.room)
    kapt(Deps.roomKapt)

    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)
    implementation(Deps.hiltNavigation)
    androidTestImplementation(Deps.hiltTesting)
    kaptAndroidTest(Deps.hiltKaptTesting)

    implementation(Deps.coil)
}


