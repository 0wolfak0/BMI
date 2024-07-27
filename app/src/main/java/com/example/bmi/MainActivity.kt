package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val weightText = findViewById<EditText>(R.id.editWeight).text.toString()
            val heightText = findViewById<EditText>(R.id.editHeight).text.toString()

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
                val weight = weightText.toDouble()
                val height = heightText.toDouble()

                val bmi = weight / (height * height)

                resultTextView.text = "Your BMI: %.2f".format(bmi)
            } else {
                resultTextView.text = "Please enter weight and height."
            }
        }
    }
}
