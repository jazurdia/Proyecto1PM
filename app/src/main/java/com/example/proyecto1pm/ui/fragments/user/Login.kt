package com.example.proyecto1pm.ui.fragments.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.proyecto1pm.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth


class Login : Fragment(R.layout.fragment_login) {

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonLogin: Button
    private lateinit var signupbtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            inputEmail = findViewById(R.id.login_email)
            inputPassword = findViewById(R.id.login_password)
            buttonLogin = findViewById(R.id.login_continuarbtn)
            signupbtn = findViewById(R.id.login_signupbtn)
        }
        requireActivity().findViewById<View>(R.id.bottom_navigation).visibility = View.GONE

        // métodos
        acceder()
        irARegistro()


    }


    private fun navigateToWorkoutScreen() {
        requireView().findNavController().navigate(R.id.action_login_to_workoutList) //Se debe modificar navigate() por que esta forma no puede compartir parámetros.
    }

    private fun navigateToRegistroScreen() {
        requireView().findNavController().navigate(
            LoginDirections.actionLoginToRegistro()
        )
    }

    // Métodos de Firebase
    // Tal vez se queden sin usar otros métodos.
    private fun acceder(){
        buttonLogin.setOnClickListener(){
            if(inputEmail.editText!!.text.toString().isNotEmpty() && inputPassword.editText!!.text.toString().isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(inputEmail.editText!!.text.toString(), inputPassword.editText!!.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        navigateToWorkoutScreen()
                    }else{
                        Toast.makeText(requireContext(), "El usuario o la contraseña no son correctos", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(requireContext(), "El usuario o la contraseña no son correctos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun irARegistro(){
        signupbtn.setOnClickListener(){
            navigateToRegistroScreen()
        }
    }


}