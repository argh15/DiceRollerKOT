package com.example.android.dicerollerkot

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rollDiceImgPrimary: ImageView
    private lateinit var rollDiceImgSecondary: ImageView
    private lateinit var rollButton: Button
    private lateinit var countUpButton: Button
    private lateinit var rollValuePrimary: TextView
    private lateinit var rollValueSecondary: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        countUpButton = findViewById(R.id.count_up_button)
        rollValuePrimary = findViewById(R.id.roll_value_primary)
        rollValueSecondary = findViewById(R.id.roll_value_secondary)
        rollDiceImgPrimary = findViewById(R.id.roll_dice_primary)
        rollDiceImgSecondary = findViewById(R.id.roll_dice_secondary)


        rollButton.setOnClickListener { rollDice(rollValuePrimary, rollValueSecondary, rollDiceImgPrimary, rollDiceImgSecondary) }
        countUpButton.setOnClickListener{ countUp(rollValuePrimary, rollValueSecondary)}
    }

    private fun countUp(textViewPrim: TextView, textViewSecond: TextView) {
        incrementValueByOne(textViewPrim)
        incrementValueByOne(textViewSecond)
    }

    private fun incrementValueByOne(textView: TextView) {
        val currentVal = textView.text.toString()
        if(currentVal == application.resources.getString(R.string.hello_world)) {
            textView.text = application.resources.getString(R.string.one)
        }else {
            var currentVarInt = currentVal.toInt()
            if(currentVarInt < 6) {
                currentVarInt++
                textView.text = currentVarInt.toString()
            }
        }
    }

    private fun rollDice(textViewPrim: TextView, textViewSecond: TextView, imageViewPrim: ImageView, imageViewSecond: ImageView) {
        val randomValueForFirstDice = randomValueGenerator(1,6)
        val randomValueForSecondDice = randomValueGenerator(1,6)

        textViewPrim.text = randomValueForFirstDice.toString()
        textViewSecond.text = randomValueForSecondDice.toString()

        imageViewPrim.setImageResource(selectDiceImage(randomValueForFirstDice))
        imageViewSecond.setImageResource(selectDiceImage(randomValueForSecondDice))
    }

    private fun randomValueGenerator(firstNum: Int, secondNum: Int): Int {
        return (firstNum..secondNum).random()
    }

    private fun selectDiceImage(randomValue: Int): Int {

        return when (randomValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
    }

}
