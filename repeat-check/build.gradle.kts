plugins {
    kotlin("jvm")
}

group = project.property("GROUP_ID") as String
version = project.property("VERSION_NAME") as String


apply(from = "../scripts/publish-mavencentral.gradle")

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}