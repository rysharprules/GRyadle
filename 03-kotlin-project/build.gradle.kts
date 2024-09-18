plugins {
    application
    kotlin("jvm") version "2.0.20" // Kotlin 2.0.20 is fully compatible with Gradle 6.8.3 through 8.6 (18-Sept-24 https://kotlinlang.org/docs/gradle-configure-project.html#apply-the-plugin)

    /* Groovy
    id 'org.jetbrains.kotlin.jvm' version '2.0.20'
    id 'application'
     */
}
kotlin {
    // sourceSets go here
}
application {
    mainClass.set("HelloKt") // Note need to append Kt
}
repositories {
    mavenCentral()
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}
version = "2.0" // This will be included in final .jar name (03-kotlin-project-2.0.jar)