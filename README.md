# RepeatCheck Utility

## Overview

RepeatCheck is a Kotlin utility designed specifically for testing environments. It provides a robust mechanism to repeatedly check assert conditions until they are verified or a maximum number of attempts is reached. This utility is especially useful for tests involving asynchronous operations, ensuring conditions are met before proceeding.

## Features

- **Asynchronous Support**: Built with coroutines, RepeatCheck allows for suspending assert conditions, making it perfect for asynchronous testing scenarios.
- **Customizable Delays and Attempts**: Configure initial delays and maximum attempt counts to suit your test setup.
- **Backup Action**: Specify a backup action to be invoked after a certain number of failed attempts, allowing for corrective measures during testing.
- **Exception Handling**: Throws a detailed exception if the condition is not met within the allowed attempts, ensuring test failures are informative.

## Requirements

- Kotlin 1.3+
- kotlinx.coroutines for asynchronous support

## Installation

Include RepeatCheck directly in your test source directory. Ensure kotlinx.coroutines is available in your project:

```kotlin
dependencies {
    testImplementation("io.github.ciriti:repeat-check:0.0.1")
    androidTestImplementation("io.github.ciriti:repeat-check:0.0.1")
    // Other dependencies...
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}
```
## Usage
### Basic Example

```kotlin
@Test
fun `check until the alias matches the expected value`() = runBlocking {
        var counter = 0
        rc { assertEquals(4, counter++) }
}

```
### With Backup Action
```kotlin
fun `check until the alias matches the expected value`() = runBlocking {
    var counter = 0
    rc(backup = { println("If fail execute the backup action") }) { assertEquals(4, counter++) }
}
```
### Advanced Usage
```kotlin
fun `check until the alias matches the expected value`() = runBlocking {
    var counter = 0
    rc(initialDelay = 200, maxAttempts = 30, backup = { /* Custom backup logicn*/ } ){ assertEquals(4, counter++) }
}
```
## Note
RepeatCheck is designed for testing purposes and should not be used in production code. It aims to simplify asynchronous testing by providing a clear pattern for condition verification with customizable retry mechanisms.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE.txt) file for details.

