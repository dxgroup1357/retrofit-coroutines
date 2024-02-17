package com.mytasklist.androidandkotlinweekly.ui.mapacitity

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.androidandkotlinweekly.brinfotech.R
import com.androidandkotlinweekly.brinfotech.databinding.ActivityMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mytasklist.androidandkotlinweekly.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapActivity : BaseActivity<ActivityMapBinding, MapViewModel>(), OnMapReadyCallback {
    override val layoutId: Int = R.layout.activity_map

    private var currentLocation: Location? = null
    lateinit var locationManager: LocationManager


    private val requestcode = 1001

//    val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
   // val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

    private val activityResultLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()){ isGranted ->
            // Handle Permission granted/rejected
            if (isGranted) {
                // Permission is granted
                getLocationData()
            } else {
                // Permission is denied
            }
        }

    private fun getLocationData() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            5000,
            0F,
            gpsLocationListener
        )
        // }

        val lastKnownLocationByGps =
            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        lastKnownLocationByGps?.let {
            currentLocation = lastKnownLocationByGps
            val cameraUpdate: CameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(currentLocation?.latitude!!,currentLocation?.longitude!!), 10f)
            googleMap?.animateCamera(cameraUpdate)
        }
    }

    var googleMap:GoogleMap? = null
    val gpsLocationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            currentLocation= location
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
    //------------------------------------------------------//
    val networkLocationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            currentLocation= location
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    override fun observeEvents() {

    }

    override fun init() {
        setUpMap()
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onResume() {
        super.onResume()
        activityResultLauncher.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE).toString()
        )
    }

    private fun setUpMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapContainer) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(childMap: GoogleMap) {
        googleMap  = childMap
        googleMap?.addMarker(
            MarkerOptions()
                .position(LatLng(0.0, 0.0))
                .title("Marker")
        )

        //if (hasGps) {

//------------------------------------------------------//
       /* if (locationByGps != null && locationByNetwork != null) {
            if (locationByGps.accuracy > locationByNetwork!!.accuracy) {
                currentLocation = locationByGps
                latitude = currentLocation.latitude
                longitude = currentLocation.longitude
                // use latitude and longitude as per your need
            } else {
                currentLocation = locationByNetwork
                latitude = currentLocation.latitude
                longitude = currentLocation.longitude
                // use latitude and longitude as per your need
            }
        }*/
    }

    private fun isLocationPermissionGranted(): Boolean {
        return if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                requestcode
            )
            false
        } else {
            true
        }
    }

}