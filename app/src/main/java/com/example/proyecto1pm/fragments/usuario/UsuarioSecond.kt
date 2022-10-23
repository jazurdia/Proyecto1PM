package com.example.proyecto1pm.fragments.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyecto1pm.R


class UsuarioSecond : Fragment(R.layout.fragment_usuario_second) {

    private lateinit var pesoInicial: TextView
    private lateinit var pesoActual: TextView
    private lateinit var pesoDeseado: TextView
    private lateinit var objetivoSemanal: TextView
    private lateinit var nivelActividad: TextView
    private lateinit var enfoqueActual: TextView

    private lateinit var sesionesPorSemanas: TextView
    private lateinit var minutosPorSesion: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {

            pesoInicial = findViewById(R.id.usuariosecond_pesoinicial)
            pesoActual = findViewById(R.id.usuariosecond_pesoactual)
            pesoDeseado = findViewById(R.id.usuariosecond_pesodeseado)
            objetivoSemanal = findViewById(R.id.usuariosecond_objetivoSemanal)
            nivelActividad = findViewById(R.id.usuariosecond_nivelActividad)
            enfoqueActual = findViewById(R.id.usuariosecond_enfoqueActual)
            sesionesPorSemanas = findViewById(R.id.usuariosecond_sesionesPorSemana)
            minutosPorSesion = findViewById(R.id.usuariosecond_MinutosPorSesion)
        }

        actualizarDatos()

    }

    private fun actualizarDatos(){ // hay que definir métodos que vengan de la base de datos interna para actualizar los datos
        pesoInicial.text = "80kg"
        pesoActual.text = "70kg"
        pesoDeseado.text = "60kg"
        objetivoSemanal.text = "1kg"
        nivelActividad.text = "Moderado"
        enfoqueActual.text = "Perder peso"
        sesionesPorSemanas.text = "3"
        minutosPorSesion.text = "30"
    }
    


}