package com.example.proyecto1pm.ui.fragments.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.proyecto1pm.R


class UsuarioMain : Fragment (R.layout.fragment_usuario_main) {

    private lateinit var username: TextView
    private lateinit var racha: TextView
    private lateinit var masaPerdida: TextView

    private lateinit var btn_objetivosUsuarios: ImageButton
    private lateinit var btn_actualizarDatos: ImageButton
    private lateinit var btn_otrasConfiguraciones: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {

            // ImageButtons que llevarán a los fragments de objetivos, actualizar datos y otras configuraciones
            btn_objetivosUsuarios = findViewById(R.id.usuariomain_iconoObjetivoUsuario)
            btn_actualizarDatos = findViewById(R.id.usuariomain_iconoActualizarDatos)
            btn_otrasConfiguraciones = findViewById(R.id.usuariomain_iconoConfiguraciones)

            // agregar métodos para ir a los fragments.


            // Recordar que son TextView. Estos son los TextView "editables" a la derecha.
            username = findViewById(R.id.usuariomain_fotoUsuario)
            racha = findViewById(R.id.usuariomain_dias)
            masaPerdida = findViewById(R.id.usuariomain_kgperdidos)

        }
    }

    private fun onClickListener() {
        btn_objetivosUsuarios.setOnClickListener {
            //requireView().findNavController().navigate()
        }

        btn_actualizarDatos.setOnClickListener {
            // Ir a fragment de actualizar datos
        }

        btn_otrasConfiguraciones.setOnClickListener {
            // Ir a fragment de otras configuraciones
        }
    }

    private fun asignarUsuario(){

    }

    private fun asignarracha(){

    }

    private fun asignarMasaPerdida(){

    }




}