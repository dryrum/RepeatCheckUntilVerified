plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.dokka") version "1.6.10"
}

apply(from = "../scripts/publish-mavencentral.gradle")

group = project.property("GROUP_ID") as String
version = rootProject.extra.get("VERSION_NAME") as String

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}