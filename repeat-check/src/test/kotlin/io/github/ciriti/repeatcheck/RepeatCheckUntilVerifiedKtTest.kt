package io.github.ciriti.repeatcheck

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatCheckUntilVerifiedKtTest {
    @Test
    fun `check until the alias matches the expected value`() = runBlocking {
        var counter = 0
        rc { assertEquals(4, counter++) }
    }
    @Test
    fun `check until repeatCheckUntilVerified matches the expected value`() = runBlocking {
        var counter = 0
        repeatCheckUntilVerified { assertEquals(4, counter++) }
    }
    @Test
    fun `check until repeatCheckUntilVerified matches the expected value1`() = runBlocking {
        var counter = 0
        repeatCheckUntilVerified { assertEquals(4, counter++) }
    }
}
