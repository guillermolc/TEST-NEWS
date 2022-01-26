dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven (url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

rootProject.name = "News"
include(":app")
include(":data")
include(":domain")
include(":usecases")
include(":testShared")
