plugins {
    kotlin("jvm") version "1.9.22"
}

group = "io.github.ciriti"
version = "1.0-SNAPSHOT"

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