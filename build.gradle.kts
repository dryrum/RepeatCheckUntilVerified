// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.2.0" apply false

    id("io.github.dryrum.update-changelog") version ("0.7.0") apply false
    id ("io.github.dryrum.replace-in-file") version ("0.7.0") apply false
    id ("io.github.dryrum.git-utils") version ("0.7.0") apply false
    id ("io.github.dryrum.bump-version-code") version ("0.7.0") apply false
}

