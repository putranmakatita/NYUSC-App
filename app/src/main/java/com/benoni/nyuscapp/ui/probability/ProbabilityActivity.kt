package com.benoni.nyuscapp.ui.probability

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.benoni.nyuscapp.R

class ProbabilityActivity : AppCompatActivity() {

    private lateinit var inputN: EditText
    private lateinit var inputR: EditText
    private lateinit var btnCombination: Button
    private lateinit var btnPermutation: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_probability)

        inputN = findViewById(R.id.inputN)
        inputR = findViewById(R.id.inputR)
        btnCombination = findViewById(R.id.btnCombination)
        btnPermutation = findViewById(R.id.btnPermutation)
        textResult = findViewById(R.id.textResult)

        btnCombination.setOnClickListener {
            calculateCombination()
        }

        btnPermutation.setOnClickListener {
            calculatePermutation()
        }
    }

    private fun calculateCombination() {
        val n = inputN.text.toString().toIntOrNull()
        val r = inputR.text.toString().toIntOrNull()

        if (n == null || r == null || r > n) {
            textResult.text = "Invalid input"
            return
        }

        val result = factorial(n) / (factorial(r) * factorial(n - r))
        textResult.text = "C($n,$r) = $result"
    }

    private fun calculatePermutation() {
        val n = inputN.text.toString().toIntOrNull()
        val r = inputR.text.toString().toIntOrNull()

        if (n == null || r == null || r > n) {
            textResult.text = "Invalid input"
            return
        }

        val result = factorial(n) / factorial(n - r)
        textResult.text = "P($n,$r) = $result"
    }

    private fun factorial(num: Int): Long {
        var result = 1L
        for (i in 1..num) {
            result *= i
        }
        return result
    }
}