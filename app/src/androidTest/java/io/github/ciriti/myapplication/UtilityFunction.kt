package io.github.ciriti.myapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

fun assertGreetingVisible() =
    Espresso.onView(ViewMatchers.withId(R.id.greetingTextView))
    .check(ViewAssertions.matches(ViewMatchers.withText("Hello Android!")))