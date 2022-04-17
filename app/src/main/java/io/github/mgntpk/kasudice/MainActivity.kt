package io.github.mgntpk.kasudice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent.*
import io.github.mgntpk.kasudice.databinding.ActivityMainBinding
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun diceRoll(): Int = SecureRandom().nextInt(6)+1

        "${diceRoll()}".also { binding.textView.text = it }

        binding.textView.setOnTouchListener { view, event ->
            if (event.action == ACTION_DOWN){
                "${diceRoll()}".also { binding.textView.text = it }
            }
            true
        }
    }
}



