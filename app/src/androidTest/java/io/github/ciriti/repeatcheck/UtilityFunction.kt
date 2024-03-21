package io.github.ciriti.repeatcheck


fun assertGreetingVisible() = assertVisibleByIdAndText(resId = R.id.greetingTextView, text = "GreetingText")