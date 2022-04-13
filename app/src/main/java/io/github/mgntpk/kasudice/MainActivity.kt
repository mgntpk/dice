package io.github.mgntpk.kasudice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import io.github.mgntpk.kasudice.databinding.ActivityMainBinding
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        "${diceRoll()}".also { binding.textView.text = it }
    }


    private fun diceRoll(): Int = SecureRandom().nextInt(6)+1

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            val textView: TextView = findViewById(R.id.textView)
            "${diceRoll()}".also { textView.text = it }

        }
        return super.onTouchEvent(event)
    }


}



