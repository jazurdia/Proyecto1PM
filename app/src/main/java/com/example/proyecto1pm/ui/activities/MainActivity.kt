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
        bottomNav= findViewById(R.id.bottom_navigation)

    }

    override fun onStart() {
        super.onStart()
        controlador = findNavController(R.id.fragmentContainer_mainActivity)
        controlador.navigate(R.id.login)
    }

    fun setListeners(){
        //usar controlador de navegacion para los fragments
        bottomNav.setOnItemReselectedListener{
            item ->
            when(item.itemId){
                R.id.action_workoutPlans -> controlador.navigate(R.id.workoutList)
                R.id.action_Alimentacion -> controlador.navigate(R.id.alimentacionList)
                R.id.action_Progreso -> controlador.navigate(R.id.progreso)
            }
        }

    }
}