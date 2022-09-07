package com.twitter.mgntpk.dice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent.ACTION_DOWN
import androidx.appcompat.app.AppCompatActivity
import com.twitter.mgntpk.dice.databinding.ActivityMainBinding
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun diceRoll(): Int = SecureRandom().nextInt(6) + 1

        "${diceRoll()}".also { binding.textView.text = it }

        binding.textView.setOnTouchListener { _, event ->
            if (event.action == ACTION_DOWN) {
                "${diceRoll()}".also { binding.textView.text = it }
            }
            true
        }
    }
}