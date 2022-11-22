package com.example.proyecto1pm.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.proyecto1pm.R
import com.example.proyecto1pm.ui.fragments.alimentacion.AlimentacionDetails
import com.example.proyecto1pm.ui.fragments.alimentacion.AlimentacionList
import com.example.proyecto1pm.ui.fragments.user.Progreso
import com.example.proyecto1pm.ui.fragments.workoutplan.WorkoutList
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var bottomNav : BottomNavigationView
    private lateinit var controlador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer_mainActivity) as NavHostFragment
        controlador = navHostFragment.navController
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottom_navigation)
        setListener()
    }

    private fun setListener() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_workoutPlans-> setFragment(WorkoutList())
                R.id.action_Alimentacion -> setFragment(AlimentacionList())
                R.id.action_Progreso -> setFragment(Progreso())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer_mainActivity, fragment)
        }
    }
}