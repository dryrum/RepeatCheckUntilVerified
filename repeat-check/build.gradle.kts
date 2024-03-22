plugins {
    kotlin("jvm")
    id("io.github.dryrum.update-changelog")
    id ("io.github.dryrum.replace-in-file")
    id ("io.github.dryrum.git-utils")
}

group = project.property("GROUP_ID") as String
version = project.property("VERSION_NAME") as String

apply(from = "${project.rootDir.path}/scripts/ktlint_utils.gradle")
apply(from = "../scripts/publish-mavencentral.gradle")

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}

addCommitPushConfig {
    fileList = listOf(
        "${rootDir.path}/CHANGELOG.md",
        "${rootDir.path}/README.md",
    )
}

replaceInFile {
    val versionName = project.property("VERSION_NAME") as String
    docs {
        create("doc") {
            path = "${rootDir.path}/README.md"
            find = "io.github.ciriti:repeat-check:(\\d)+\\.(\\d)+\\.(\\d)+"
            replaceWith = "io.github.ciriti:repeat-check:$versionName"
        }
    }
}

changeLogConfig {
    val versionName = project.property("VERSION_NAME") as String
    changeLogPath = rootDir.path + "/CHANGELOG.md"
    content = file(  "${rootDir.path}/${project.name}/release_note.txt").readText()
    version = versionName
}