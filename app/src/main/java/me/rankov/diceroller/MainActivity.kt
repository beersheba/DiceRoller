package me.rankov.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val clearButton: Button = findViewById(R.id.clear_button)
        diceImage1 = findViewById(R.id.dice_image_1)
        diceImage2 = findViewById(R.id.dice_image_2)

        rollButton.setOnClickListener {
            rollDice(diceImage1)
            rollDice(diceImage2)
        }

        clearButton.setOnClickListener {
            clearDice(diceImage1)
            clearDice(diceImage2)
        }
    }

    private fun clearDice(diceImage: ImageView) {
        diceImage.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice(diceImage: ImageView) {
        val randomInt = Random.nextInt(6) + 1
        val resourceId = resources.getIdentifier("dice_".plus(randomInt), "drawable", packageName)
        diceImage.setImageResource(resourceId)
    }

}
