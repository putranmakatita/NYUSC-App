package com.benoni.nyuscapp.ui.reference

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.benoni.nyuscapp.R

class ReferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reference)

        val btnHaversine = findViewById<Button>(R.id.btnHaversine)
        val btnCombination = findViewById<Button>(R.id.btnCombination)
        val btnPermutation = findViewById<Button>(R.id.btnPermutation)
        val btnDerivative = findViewById<Button>(R.id.btnDerivative)

        btnHaversine.setOnClickListener {
            openLink("https://en.wikipedia.org/wiki/Haversine_formula")
        }

        btnCombination.setOnClickListener {
            openLink("https://en.wikipedia.org/wiki/Combination")
        }

        btnPermutation.setOnClickListener {
            openLink("https://en.wikipedia.org/wiki/Permutation")
        }

        btnDerivative.setOnClickListener {
            openLink("https://en.wikipedia.org/wiki/Derivative")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}