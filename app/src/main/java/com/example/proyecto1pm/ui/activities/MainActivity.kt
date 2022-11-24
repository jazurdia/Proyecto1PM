package com.example.proyecto1pm.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.proyecto1pm.R
import com.example.proyecto1pm.ui.fragments.alimentacion.List.AlimentacionList
import com.example.proyecto1pm.ui.fragments.user.Progreso
import com.example.proyecto1pm.ui.fragments.usuario.UsuarioMain
import com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet.WorkoutList
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var bottomNav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottom_navigation)
        setListener()
    }

    private fun setListener() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_workoutPlans-> setFragment(WorkoutList())
                R.id.action_Alimentacion -> setFragment(AlimentacionList())
                R.id.action_Progreso -> setFragment(UsuarioMain())
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