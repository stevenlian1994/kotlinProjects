package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countButton: Button = findViewById(R.id.count_button)
        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener {countUp()}
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(6) + 1
        val result_text: TextView = findViewById(R.id.result_text)
        result_text.text = randomInt.toString()
//        Toast.makeText(this, randomInt,
//            Toast.LENGTH_SHORT).show()
    }
    private fun countUp(){
        if(result_text.text != "Hello World!" && result_text.text != "6" ){
            val result_text: TextView = findViewById(R.id.result_text)
            val new_value = result_text.text.toString().toInt() + 1
            result_text.text = new_value.toString()
        }
    }
}
