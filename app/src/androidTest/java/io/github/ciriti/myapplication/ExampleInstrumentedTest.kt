package io.github.ciriti.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.ciriti.repeatcheck.rc
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun activityLaunches() = runBlocking<Unit> {
        ActivityScenario.launch(MainActivity::class.java)
        rc { assertGreetingVisible() }
    }

    @Test
    fun activityLaunches2() = runBlocking<Unit> {
        ActivityScenario.launch(MainActivity::class.java)
        assertGreetingVisible()
    }
}