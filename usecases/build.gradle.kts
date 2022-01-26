plugins {
    id ("java-library")
    id ("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies{
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":testShared"))

    implementation(Deps.coroutinesCore)

    testImplementation(Deps.jUnitImplementation)
    testImplementation(Deps.mockito)
    testImplementation(Deps.mockitoInline)
    testImplementation(Deps.testCoroutines)
}