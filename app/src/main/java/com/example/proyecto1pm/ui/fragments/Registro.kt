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


class Registro : Fragment(R.layout.fragment_registro) {

    private lateinit var inputCorreo: TextInputLayout
    private lateinit var inputContraseña: TextInputLayout
    private lateinit var inputConfirmarContraseña: TextInputLayout
    private lateinit var boton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            inputCorreo = findViewById(R.id.textInputLayout)
            inputContraseña = findViewById(R.id.registro_contrasena)
            inputConfirmarContraseña = findViewById(R.id.textInputLayout2)
        }

    }

    private fun setListeners() {
        boton.setOnClickListener {
            RegistrarNuevoUsuario(
                correo = inputCorreo.editText!!.text.toString(),
                contraseña = inputContraseña.editText!!.text.toString(),
                confirmarContraseña = inputConfirmarContraseña.editText!!.text.toString()
            )
        }
    }

    private fun RegistrarNuevoUsuario(correo: String, contraseña: String, confirmarContraseña: String) {

        if(contraseña == confirmarContraseña) {
            // pasarle parámetros a la base de datos.
        } else {
            Toast.makeText(requireContext(), "Contraseña no coincide", Toast.LENGTH_SHORT).show()

        }
    }

    private fun navigateToLogInScreen() {
        // falta definir el navController
    }


}