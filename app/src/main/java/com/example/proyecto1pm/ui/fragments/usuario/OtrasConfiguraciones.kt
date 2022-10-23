package com.example.proyecto1pm.ui.fragments.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.proyecto1pm.R


class OtrasConfiguraciones : Fragment() {

    private lateinit var spinner_enfoque: Spinner
    private lateinit var spinner_masa: Spinner
    private lateinit var spinner_porcentajeGrasa: Spinner
    private lateinit var spinner_altura: Spinner
    private lateinit var spinner_edad: Spinner
    //private lateinit var spinner_metaInicial: Spinner no sé porque no funciona.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            spinner_enfoque = findViewById(R.id.otrasconfiguraciones_spinner_enfoquedelusuario)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.enfoque_del_usuario_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_enfoque.adapter = adapter
            }

            spinner_masa = findViewById(R.id.otrasconfiguraciones_spinner_masausuario)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.masa_del_usuario_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_masa.adapter = adapter
            }
            spinner_porcentajeGrasa = findViewById(R.id.otrasconfiguraciones_spinner_porcentajedegrasa)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.porcentaje_de_grasa_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_porcentajeGrasa.adapter = adapter
            }
            spinner_altura = findViewById(R.id.otrasconfiguraciones_spinner_alturaUsuario)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.altura_del_usuario_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_altura.adapter = adapter
            }
            spinner_edad = findViewById(R.id.otrasconfiguraciones_spinner_edadUsuario)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.edad_del_usuario_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_edad.adapter = adapter
            }


        }

        requireActivity().findViewById<View>(R.id.bottom_navigation).visibility = View.GONE
    }



}