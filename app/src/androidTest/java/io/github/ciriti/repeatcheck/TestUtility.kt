package io.github.ciriti.repeatcheck

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.*
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import org.hamcrest.core.AllOf

fun assertVisibleByIdAndText(
    @IdRes resId: Int,
    text: String
) {
    onView(
        AllOf.allOf(
            ViewMatchers.withId(resId),
            ViewMatchers.withText(text),
            isDisplayed()
        )
    )
}

@Throws(Throwable::class)
fun assertVisibleByIdAndText(text: String) {
    onView(
        withContentDescription(text)
    ).check(ViewAssertions.matches(isDisplayed()))
}