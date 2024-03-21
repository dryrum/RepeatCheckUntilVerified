package io.github.ciriti.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_app)

        Handler(Looper.getMainLooper()).postDelayed({
            findViewById<TextView>(R.id.greetingTextView).text = "Hello Android!"
        }, getRandomDelay())
    }

    private fun getRandomDelay(): Long {
        return Random.nextLong(1000L, 2001L)
    }
}