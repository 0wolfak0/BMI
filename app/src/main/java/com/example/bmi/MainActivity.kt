package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
                if (bmi < 18.5) {
                    Toast.makeText(this, "underweight and possibly malnourished", Toast.LENGTH_SHORT).show()
                }
                else if (bmi < 24.9) {
                    Toast.makeText(this, "healthy weight range for young and middle-aged adults", Toast.LENGTH_SHORT).show()
                }
                else if (bmi < 29.9) {
                    Toast.makeText(this, " overweight", Toast.LENGTH_SHORT).show()
                }
                else if (bmi > 30) {
                    Toast.makeText(this, "obese", Toast.LENGTH_SHORT).show()
                }
            } else {
                resultTextView.text = "Please enter weight and height."
            }
        }
    }
}
