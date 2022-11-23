package com.example.proyecto1pm.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.proyecto1pm.R
import com.example.proyecto1pm.ui.fragments.alimentacion.List.AlimentacionList
import com.example.proyecto1pm.ui.fragments.user.Progreso
import com.example.proyecto1pm.ui.fragments.workoutplan.WorkoutList
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var bottomNav : BottomNavigationView
    private lateinit var controlador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottom_navigation)
        setListener()
    }

    private fun setListener() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_workoutPlans-> controlador.navigate(R.id.action_workoutPlans)
                R.id.action_Alimentacion -> setFragment(AlimentacionList())
                R.id.action_Progreso -> setFragment(Progreso())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer_mainActivity, fragment)
            commit()
        }
    }
}