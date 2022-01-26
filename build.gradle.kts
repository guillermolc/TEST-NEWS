buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(BuildPlugin.android)
        classpath(BuildPlugin.kotlin)
        classpath(BuildPlugin.hilt)
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
