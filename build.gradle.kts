// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPath.com_android_tools_build_gradle)
        classpath(ClassPath.kotlin_gradle_plugin)
        classpath(ClassPath.hilt_android_gradle_plugin)
        classpath(ClassPath.tools_build_gradle)
        classpath(ClassPath.versions)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

apply(plugin = "com.github.ben-manes.versions")

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://maven.google.com/")
    }
}

tasks.withType<Wrapper> {
    gradleVersion = Versions.gradleVersion
    distributionType = Wrapper.DistributionType.ALL
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}