package com.benoni.nyuscapp.ui.molar

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.benoni.nyuscapp.R
import org.json.JSONArray
import java.io.IOException

class MolarActivity : AppCompatActivity() {

    private lateinit var inputFormula: EditText
    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    private var atomicMass: Map<String, Double> = emptyMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_molar)

        inputFormula = findViewById(R.id.inputFormula)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

        // 🔥 Load JSON with error handling
        try {
            atomicMass = loadAtomicMass()
        } catch (e: Exception) {
            Log.e("MolarActivity", "Error loading atomic mass data", e)
            Toast.makeText(this, "Failed to load chemical data", Toast.LENGTH_LONG).show()
        }

        btnCalculate.setOnClickListener {
            calculateMolarMass()
        }
    }

    // 🔹 Load JSON from assets
    private fun loadAtomicMass(): Map<String, Double> {
        val map = mutableMapOf<String, Double>()

        try {
            val jsonString = assets.open("atomic_mass.json")
                .bufferedReader()
                .use { it.readText() }

            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val symbol = obj.getString("symbol")
                val mass = obj.getDouble("mass")
                map[symbol] = mass
            }
        } catch (e: IOException) {
            throw e
        } catch (e: Exception) {
            throw e
        }

        return map
    }

    // 🔹 Calculate molar mass
    private fun calculateMolarMass() {
        val formula = inputFormula.text.toString().trim()

        if (formula.isEmpty()) {
            textResult.text = "Enter a formula"
            return
        }

        if (atomicMass.isEmpty()) {
            textResult.text = "Data not loaded"
            return
        }

        val regex = Regex("([A-Z][a-z]?)(\\d*)")
        val matches = regex.findAll(formula)

        if (!matches.any()) {
            textResult.text = "Invalid formula format"
            return
        }

        var totalMass = 0.0

        for (match in matches) {
            val element = match.groupValues[1]
            val countStr = match.groupValues[2]

            val count = if (countStr.isEmpty()) 1 else {
                countStr.toIntOrNull() ?: 1
            }

            val mass = atomicMass[element]

            if (mass == null) {
                textResult.text = "Unknown element: $element"
                return
            }

            totalMass += mass * count
        }

        textResult.text = "Molar Mass = %.3f g/mol".format(totalMass)
    }
}
