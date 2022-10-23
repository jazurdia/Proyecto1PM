package com.example.proyecto1pm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.proyecto1pm.R
import com.google.android.material.textfield.TextInputLayout


class Login : Fragment(R.layout.fragment_login) {

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonLogin: Button

    private var username: String = "@username"
    private var password: String = "@password"



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            view.apply {
                inputEmail = findViewById(R.id.login_email)
                inputPassword = findViewById(R.id.login_password)
                buttonLogin = findViewById(R.id.login_continuarbtn)
            }

            requireActivity().findViewById<View>(R.id.bottom_navigation).visibility = View.GONE
        }


    private fun setListeners() {
        buttonLogin.setOnClickListener {
            loginIfUser(
                email = inputEmail.editText!!.text.toString(),
                password2 = inputPassword.editText!!.text.toString()
            )
        }
    }

    private fun loginIfUser(email: String, password2: String) {
        if (email == username && password == password) {
            //navigateToListScreen()
        } else {
            Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToWorkoutScreen() {
        // falta definir el navController
    }



}