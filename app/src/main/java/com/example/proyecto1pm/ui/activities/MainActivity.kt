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
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var bottomNav : BottomNavigationView
    private lateinit var controlador: NavController

    //private var viewModel : MainViewModel by viewModels { MainViewModelFactory(emtpyList()) }

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
                R.id.action_workoutPlans-> Navigation.findNavController(this, R.id.fragmentContainer_mainActivity).navigate(R.id.fr)
                R.id.action_Alimentacion -> setFragment(AlimentacionList())
                R.id.action_Progreso -> setFragment(Progreso())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        //cambiar de fragment usando navigate
        controlador.navigate(fragment)
    }
}