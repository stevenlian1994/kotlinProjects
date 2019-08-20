package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.top
import android.R.attr.left
import android.view.ViewGroup.MarginLayoutParams
import android.view.animation.AnimationUtils
import java.util.Timer
import kotlin.concurrent.schedule
import android.view.animation.Animation



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice(){

        val diceImage1: ImageView = findViewById(R.id.dice_image_1)
        val diceImage2: ImageView = findViewById(R.id.dice_image_2)
        val drawableResource1 = getRandomDiceImage()
        val drawableResource2 = getRandomDiceImage()
        val animation  = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake);
        diceImage1.startAnimation(animation)
        diceImage2.startAnimation(animation)
        Timer("SettingUp", false).schedule(500) {
            diceImage1.setImageResource(drawableResource1)
            diceImage2.setImageResource(drawableResource2)
        }


//        val myImage = findViewById(R.id.image_view) as ImageView
//        val marginParams = image.getLayoutParams() as MarginLayoutParams
//    marginParams.setMargins(left, 82, right, bottom)

    }

    private fun getRandomDiceImage() : Int {
        val randomInt = Random().nextInt(6) + 1
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

}
