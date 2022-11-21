package com.example.proyecto1pm.ui.fragments.usuario

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
            pesoInicial.setText(getData("pesoInicial"))

            pesoActual = findViewById(R.id.usuariosecond_pesoactual)
            pesoActual.setText(getData("pesoActual"))
            pesoDeseado = findViewById(R.id.usuariosecond_pesodeseado)
            pesoDeseado.setText(getData("pesoDeseado"))
            objetivoSemanal = findViewById(R.id.usuariosecond_objetivoSemanal)
            objetivoSemanal.setText(getData("objetivoSemanal"))
            nivelActividad = findViewById(R.id.usuariosecond_nivelActividad)
            nivelActividad.setText(getData("nivelActividad"))
            enfoqueActual = findViewById(R.id.usuariosecond_enfoqueActual)
            enfoqueActual.setText(getData("enfoqueActual"))
            sesionesPorSemanas = findViewById(R.id.usuariosecond_sesionesPorSemana)
            sesionesPorSemanas.setText(getData("sesionesPorSemanas"))
            minutosPorSesion = findViewById(R.id.usuariosecond_MinutosPorSesion)
            minutosPorSesion.setText(getData("minutosPorSesion"))
        }



    }

    private fun getData(s: String): String {
        // Se debe return por el dato de db.
        when(s){
            "pesoInicial" -> return "pesoInicial"
            "pesoActual" -> return "pesoActual"
            "pesoDeseado" -> return "pesoDeseado"
            "objetivoSemanal" -> return "objetivoSemanal"
            "nivelActividad" -> return "nivelActividad"
            "enfoqueActual" -> return "enfoqueActual"
            "sesionesPorSemanas" -> return "sesionesPorSemanas"
            "minutosPorSesion" -> return "minutosPorSesion"
            else -> return "err"
        }
    }

    


}