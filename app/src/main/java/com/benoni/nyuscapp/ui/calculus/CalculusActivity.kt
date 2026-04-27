package com.benoni.nyuscapp.ui.calculus

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.benoni.nyuscapp.R
import java.util.regex.Pattern

class CalculusActivity : AppCompatActivity() {

    private lateinit var inputFunction: EditText
    private lateinit var btnDerivative: Button
    private lateinit var btnIntegral: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculus)

        inputFunction = findViewById(R.id.inputFunction)
        btnDerivative = findViewById(R.id.btnDerivative)
        btnIntegral = findViewById(R.id.btnIntegral)
        textResult = findViewById(R.id.textResult)

        btnDerivative.setOnClickListener {
            calculateDerivative()
        }

        btnIntegral.setOnClickListener {
            calculateIntegral()
        }
    }

    private fun calculateDerivative() {
        val input = inputFunction.text.toString().replace(" ", "")
        if (input.isEmpty()) {
            textResult.text = "Enter a function"
            return
        }

        val terms = splitTerms(input)
        val results = mutableListOf<String>()

        for (term in terms) {
            val derivative = deriveTerm(term)
            if (derivative.isNotEmpty() && derivative != "0") {
                results.add(derivative)
            }
        }

        if (results.isEmpty()) {
            textResult.text = "f'(x) = 0"
        } else {
            textResult.text = "f'(x) = " + formatPolynomial(results)
        }
    }

    private fun calculateIntegral() {
        val input = inputFunction.text.toString().replace(" ", "")
        if (input.isEmpty()) {
            textResult.text = "Enter a function"
            return
        }

        val terms = splitTerms(input)
        val results = mutableListOf<String>()

        for (term in terms) {
            val integral = integrateTerm(term)
            if (integral.isNotEmpty()) {
                results.add(integral)
            }
        }

        textResult.text = "∫f(x)dx = " + formatPolynomial(results) + " + C"
    }

    private fun splitTerms(input: String): List<String> {
        val terms = mutableListOf<String>()
        val matcher = Pattern.compile("([+-]?[^+-]+)").matcher(input)
        while (matcher.find()) {
            terms.add(matcher.group())
        }
        return terms
    }

    private fun deriveTerm(term: String): String {
        // Handle terms like: ax^n, ax, x, a
        val cleanTerm = if (!term.startsWith("+") && !term.startsWith("-")) "+$term" else term
        val sign = if (cleanTerm.startsWith("-")) -1 else 1
        val content = cleanTerm.substring(1)

        return when {
            content.contains("x^") -> {
                val parts = content.split("x^")
                val a = if (parts[0].isEmpty()) 1.0 else parts[0].toDoubleOrNull() ?: 1.0
                val n = parts[1].toDoubleOrNull() ?: 1.0
                val newA = a * n * sign
                val newN = n - 1
                formatTerm(newA, newN)
            }
            content.contains("x") -> {
                val aStr = content.replace("x", "")
                val a = if (aStr.isEmpty()) 1.0 else aStr.toDoubleOrNull() ?: 1.0
                val newA = a * sign
                if (newA == 0.0) "" else formatValue(newA)
            }
            else -> "0" // Constant derivative is 0
        }
    }

    private fun integrateTerm(term: String): String {
        val cleanTerm = if (!term.startsWith("+") && !term.startsWith("-")) "+$term" else term
        val sign = if (cleanTerm.startsWith("-")) -1 else 1
        val content = cleanTerm.substring(1)

        return when {
            content.contains("x^") -> {
                val parts = content.split("x^")
                val a = if (parts[0].isEmpty()) 1.0 else parts[0].toDoubleOrNull() ?: 1.0
                val n = parts[1].toDoubleOrNull() ?: 1.0
                val newN = n + 1
                val newA = (a / newN) * sign
                formatTerm(newA, newN)
            }
            content.contains("x") -> {
                val aStr = content.replace("x", "")
                val a = if (aStr.isEmpty()) 1.0 else aStr.toDoubleOrNull() ?: 1.0
                val newN = 2.0
                val newA = (a / 2.0) * sign
                formatTerm(newA, newN)
            }
            else -> { // Constant
                val a = content.toDoubleOrNull() ?: 0.0
                val newA = a * sign
                if (newA == 0.0) "" else "${formatValue(newA)}x"
            }
        }
    }

    private fun formatTerm(a: Double, n: Double): String {
        if (a == 0.0) return ""
        val aStr = when {
            a == 1.0 -> ""
            a == -1.0 -> "-"
            else -> formatValue(a)
        }
        return when {
            n == 0.0 -> formatValue(a)
            n == 1.0 -> "${aStr}x"
            else -> "${aStr}x^${formatValue(n)}"
        }
    }

    private fun formatValue(v: Double): String {
        return if (v % 1.0 == 0.0) v.toInt().toString() else "%.2f".format(v)
    }

    private fun formatPolynomial(terms: List<String>): String {
        if (terms.isEmpty()) return "0"
        var result = terms[0]
        for (i in 1 until terms.size) {
            val term = terms[i]
            if (term.startsWith("-")) {
                result += " - " + term.substring(1)
            } else {
                result += " + " + term
            }
        }
        return result
    }
}
