package com.example.proyecto1pm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.proyecto1pm.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth


class Registro : Fragment(R.layout.fragment_registro) {

    private lateinit var inputCorreo: TextInputLayout
    private lateinit var inputContraseña: TextInputLayout
    private lateinit var inputConfirmarContraseña: TextInputLayout
    private lateinit var btn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            inputCorreo = findViewById(R.id.registro_email_TextInputLayout)
            inputContraseña = findViewById(R.id.registro_password_TextInputLayout)
            inputConfirmarContraseña = findViewById(R.id.registro_confPassword_TextInputLayout)
            btn = findViewById(R.id.registro_confirmar_button)

        }

    }

    private fun RegistrarNuevoUsuario() {

        btn.setOnClickListener() {
            if (inputCorreo.editText!!.text.toString().isNotEmpty() && inputContraseña.editText!!.toString().isNotEmpty() && inputConfirmarContraseña.editText!!.toString().isNotEmpty()) {
                //Toast.makeText(requireContext(), "Usuario registrado", Toast.LENGTH_SHORT).show()
                if(inputContraseña.editText!!.text.toString() == inputConfirmarContraseña.editText!!.text.toString()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(inputCorreo.editText!!.text.toString(), inputContraseña.editText!!.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(requireContext(), "Usuario registrado", Toast.LENGTH_SHORT).show()

                            // ir a workoutList
                            navigateToWorkoutListScreen()


                        }else{
                            Toast.makeText(requireContext(), "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }


            } else {
                Toast.makeText(requireContext(), "Verifica tus datos", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun navigateToLogInScreen() {

    }

    private fun navigateToWorkoutListScreen() {

        requireView().findNavController().navigate(R.id.action_registro_to_workoutList)
        // tal vez sea necesario modificar este método.

    }


}