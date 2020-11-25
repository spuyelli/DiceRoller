package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            // MI SOLUCION
            // Toast.makeText(this, "Dice Rolled!",Toast.LENGTH_SHORT).show()
            // val dado = Dice(6)
            // findViewById<TextView>(R.id.textView).text = dado.roll().toString()

            // LA SOLUCION DE CODELABS
            rollDice(R.id.imageView1)
            rollDice(R.id.imageView2)
        }

        rollDice(R.id.imageView1)
        rollDice(R.id.imageView2)
    }

    private fun rollDice(ImageViewID: Int) {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(ImageViewID)
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}