package com.benoni.nyuscapp.ui.distance

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.benoni.nyuscapp.R
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import kotlin.math.*

class DistanceActivity : AppCompatActivity() {

    private lateinit var map: MapView
    private lateinit var lat1: EditText
    private lateinit var lon1: EditText
    private lateinit var lat2: EditText
    private lateinit var lon2: EditText
    private lateinit var btnSetP1: Button
    private lateinit var btnSetP2: Button
    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    private var marker1: Marker? = null
    private var marker2: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // OSMDroid configuration
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        
        setContentView(R.layout.activity_distance)

        map = findViewById(R.id.map)
        lat1 = findViewById(R.id.lat1)
        lon1 = findViewById(R.id.lon1)
        lat2 = findViewById(R.id.lat2)
        lon2 = findViewById(R.id.lon2)
        btnSetP1 = findViewById(R.id.btnSetPoint1)
        btnSetP2 = findViewById(R.id.btnSetPoint2)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

        initMap()

        btnSetP1.setOnClickListener {
            val center = map.mapCenter as GeoPoint
            lat1.setText(center.latitude.toString())
            lon1.setText(center.longitude.toString())
            updateMarker(1, center)
        }

        btnSetP2.setOnClickListener {
            val center = map.mapCenter as GeoPoint
            lat2.setText(center.latitude.toString())
            lon2.setText(center.longitude.toString())
            updateMarker(2, center)
        }

        btnCalculate.setOnClickListener {
            calculateDistance()
        }

        requestPermissions()
    }

    private fun initMap() {
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(4.0)
        val startPoint = GeoPoint(-6.200000, 106.816666) // Default to Jakarta
        mapController.setCenter(startPoint)

        val receive = object : MapEventsReceiver {
            override fun singleTapConfirmedHelper(p: GeoPoint?): Boolean {
                return false
            }

            override fun longPressHelper(p: GeoPoint?): Boolean {
                // Long press can also be used to set points
                return false
            }
        }
        map.overlays.add(MapEventsOverlay(receive))
    }

    private fun updateMarker(pointIndex: Int, point: GeoPoint) {
        if (pointIndex == 1) {
            marker1?.let { map.overlays.remove(it) }
            marker1 = Marker(map).apply {
                position = point
                setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                title = "Point 1"
            }
            map.overlays.add(marker1)
        } else {
            marker2?.let { map.overlays.remove(it) }
            marker2 = Marker(map).apply {
                position = point
                setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                title = "Point 2"
            }
            map.overlays.add(marker2)
        }
        map.invalidate()
    }

    private fun calculateDistance() {
        val lat1Val = lat1.text.toString().toDoubleOrNull()
        val lon1Val = lon1.text.toString().toDoubleOrNull()
        val lat2Val = lat2.text.toString().toDoubleOrNull()
        val lon2Val = lon2.text.toString().toDoubleOrNull()

        if (lat1Val == null || lon1Val == null || lat2Val == null || lon2Val == null) {
            textResult.text = "Invalid coordinates"
            return
        }

        val result = haversine(lat1Val, lon1Val, lat2Val, lon2Val)
        textResult.text = "%.3f km".format(result)
    }

    private fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val R = 6371.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return R * c
    }

    private fun requestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, 1)
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
