package io.github.ciriti.repeatcheck

import kotlinx.coroutines.delay

@Throws(Throwable::class)
suspend fun rc(
    initialDelay: Long = 200,
    maxAttempts: Int = 30,
    backup: (() -> Unit)? = null,
    conditionCheck: () -> Unit
) = repeatCheckUntilVerified(initialDelay, maxAttempts, backup, conditionCheck)

@Throws(Throwable::class)
suspend fun repeatCheckUntilVerified(
    initialDelay: Long = 200,
    maxAttempts: Int = 30,
    onFailureBackup: (() -> Unit)? = null,
    checkConditionTask: () -> Unit
) {
    var lastFailureResult: TestRes.NotVerified = TestRes.NotVerified(RuntimeException("Condition not initialized!"))
    delay(initialDelay)
    repeat(maxAttempts) { attemptIndex ->
        delay(250)
        when (val attemptResult = checkCondition(checkConditionTask)) {
            TestRes.Verified -> return
            is TestRes.NotVerified -> {
                if (attemptIndex % 5 == 0 && attemptIndex > maxAttempts / 5) {
                    onFailureBackup?.invoke()
                }
                lastFailureResult = attemptResult
            }
            else -> throw IllegalStateException("""
                Unexpected TestRes subtype detected. 
                TestRes is a sealed class and should only have two known subclasses: Verified and NotVerified.
            """.trimIndent())
        }
    }
    throw lastFailureResult.th
}

fun checkCondition(conditionCheckTask: () -> Unit): TestRes {
    return try {
        conditionCheckTask()
        TestRes.Verified
    } catch (th: Throwable) {
        TestRes.NotVerified(th)
    }
}

sealed class TestRes {
    object Verified : TestRes()
    data class NotVerified(val th: Throwable) : TestRes()
}
