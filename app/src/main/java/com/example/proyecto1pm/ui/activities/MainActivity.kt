package com.example.proyecto1pm.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.proyecto1pm.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav : BottomNavigationView
    private lateinit var controlador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer_mainActivity) as NavHostFragment
        controlador = navHostFragment.navController
        setContentView(R.layout.activity_main)
    }
}