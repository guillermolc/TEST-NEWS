object BuildPlugin{

    val android by lazy{
        "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    }

    val kotlin by lazy{
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    val serialization by lazy{
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    }

    val hilt by lazy{
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPlugin}"
    }
}

object Deps{
    val coreKtx by lazy {
        "androidx.core:core-ktx:${Versions.coreKtx}"
    }

    val appCompat by lazy {
        "androidx.appcompat:appcompat:${Versions.appCompat}"
    }

    val material by lazy {
        "com.google.android.material:material:${Versions.material}"
    }

    val appCompanist by lazy {
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.appCompanist}"
    }

    val composeUi by lazy{
        "androidx.compose.ui:ui:${Versions.compose}"
    }

    val composeMaterial by lazy{
        "androidx.compose.material:material:${Versions.compose}"
    }

    val composePreview by lazy {
        "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    }

    val lifecycleKtx by lazy {
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    val activity by lazy{
        "androidx.activity:activity-compose:${Versions.activity}"
    }

    val jUnitImplementation by lazy {
        "junit:junit:4.13.1"
    }

    val mockito by lazy{
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    }

    val mockitoInline by lazy {
        "org.mockito:mockito-inline:${Versions.mockitoInline}"
    }

    val testCoroutines by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    }

    val espresso by lazy{
        "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    val composeJUnit by lazy{
        "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    val composeTooling by lazy {
        "androidx.compose.ui:ui-tooling:${Versions.compose}"
    }

    val coroutinesCore by lazy{
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    }

    val coroutinesAndroid by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    }

    val retrofit by lazy{
        "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    }

    val retrofitSerialization by lazy {
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerialization}"
    }

    val retrofitTickXml by lazy {
        "com.tickaroo.tikxml:retrofit-converter:${Versions.tickXml}"
    }

    val tickXmlCore by lazy{
        "com.tickaroo.tikxml:core:${Versions.tickXml}"
    }

    val tickXmlKapt by lazy {
        "com.tickaroo.tikxml:processor:${Versions.tickXml}"
    }

    val tickXmlConverter by lazy {
        "com.tickaroo.tikxml:converter-htmlescape:${Versions.tickXml}"
    }

    val tickXmlAnnotation by lazy {
        "com.tickaroo.tikxml:annotation:${Versions.tickXml}"
    }

    val serializationJson by lazy {
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationJson}"
    }

    val room by lazy{
        "androidx.room:room-runtime:${Versions.room}"
    }

    val roomKapt by lazy{
        "androidx.room:room-compiler:${Versions.room}"
    }

    val hilt by lazy{
        "com.google.dagger:hilt-android:${Versions.hilt}"
    }

    val hiltKapt by lazy {
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    val hiltNavigation by lazy {
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    }

    val hiltTesting by lazy {
        "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    }

    val hiltKaptTesting by lazy {
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    val coil by lazy {
        "io.coil-kt:coil-compose:${Versions.coil}"
    }


}