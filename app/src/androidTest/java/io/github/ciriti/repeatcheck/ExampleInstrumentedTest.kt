package io.github.ciriti.repeatcheck

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() = runBlocking<Unit> {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.ciriti.repeatcheck", appContext.packageName)
    }

    @Test
    fun GIVEN_a_deleay_VERIFY_the_label_FAIL() = runBlocking<Unit> {
        assertGreetingVisible()
    }

    @Test
    fun GIVEN_a_deleay_VERIFY_the_label_PASS() = runBlocking<Unit> {
        ActivityScenario.launch(MainActivity::class.java)
        repeatCheckUntilVerified { assertGreetingVisible() }
    }
}