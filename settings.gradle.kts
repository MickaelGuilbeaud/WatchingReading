pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WatchingReading"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // region Versions
            version("compose", "1.3.3")
            version("composeCompiler", "1.4.2")
            version("javaVersion", JavaVersion.VERSION_11.toString())
            // endregion

            // region Dependencies
            // region AndroidX
            library("androidx.activityCompose", "androidx.activity", "activity-compose").version("1.6.1")
            library("androidx.core", "androidx.core", "core-ktx").version("1.9.0")
            library("androidx.lifecycleRuntime", "androidx.lifecycle", "lifecycle-runtime-ktx").version("2.5.1")
            library("androidx.test.espressoCore", "androidx.test.espresso", "espresso-core").version("3.5.1")
            library("androidx.test.jUnit", "androidx.test.ext", "junit").version("1.1.5")
            // endregion
            // region Compose
            library("compose.material3", "androidx.compose.material3", "material3").version("1.1.0-rc01")
            library("compose.ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("compose.uiToolingPreview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("compose.uiTooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
            library("compose.uiTestManifest", "androidx.compose.ui", "ui-test-manifest").versionRef("compose")
            library("compose.uiTestJUnit4", "androidx.compose.ui", "ui-test-junit4").versionRef("compose")
            // endregion
            // region Tests
            library("jUnit", "junit", "junit").version("4.13.2")
            // endregion
            // endregion

            // region Plugins

            // endregion
        }
    }
}

include(":app")
