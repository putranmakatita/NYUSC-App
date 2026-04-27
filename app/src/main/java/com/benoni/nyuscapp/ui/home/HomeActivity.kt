package com.benoni.nyuscapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benoni.nyuscapp.R
import com.benoni.nyuscapp.ui.calculus.CalculusActivity
import com.benoni.nyuscapp.ui.distance.DistanceActivity
import com.benoni.nyuscapp.ui.molar.MolarActivity
import com.benoni.nyuscapp.ui.probability.ProbabilityActivity
import com.benoni.nyuscapp.ui.reference.ReferenceActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnMolar = findViewById<View>(R.id.btnMolar)
        val btnDistance = findViewById<View>(R.id.btnDistance)
        val btnProbability = findViewById<View>(R.id.btnProbability)
        val btnCalculus = findViewById<View>(R.id.btnCalculus)
        val btnReference = findViewById<View>(R.id.btnReference)

        btnMolar.setOnClickListener {
            startActivity(Intent(this, MolarActivity::class.java))
        }

        btnDistance.setOnClickListener {
            startActivity(Intent(this, DistanceActivity::class.java))
        }

        btnProbability.setOnClickListener {
            startActivity(Intent(this, ProbabilityActivity::class.java))
        }

        btnCalculus.setOnClickListener {
            startActivity(Intent(this, CalculusActivity::class.java))
        }

        btnReference.setOnClickListener {
            startActivity(Intent(this, ReferenceActivity::class.java))
        }
    }
}
