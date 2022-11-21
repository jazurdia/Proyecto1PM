package com.example.proyecto1pm.ui.fragments.user

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.proyecto1pm.R
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button

class OtrasConf : Fragment(R.layout.fragment_otras_configuraciones) {

    private lateinit var enfoque : Spinner
    private lateinit var masa : Spinner
    private lateinit var grasa : Spinner
    private lateinit var altura : Spinner
    private lateinit var edad : Spinner
    private lateinit var meta : Spinner
    private lateinit var btn : Button

    lateinit var opEnfoque : String
    lateinit var opMasa : String
    lateinit var opGrasa : String
    lateinit var opAltura : String
    lateinit var opEdad : String
    lateinit var opMeta : String



    var array_enfoque: Array<String> = arrayOf("Perder peso", "Ganar peso", "Mantener peso")
    var array_masa: Array<String> = arrayOf("60 kg", "70 kg", "80 kg", "90 kg", "100 kg", "110 kg", "120 kg", "130 kg", "140 kg", "150 kg", "160 kg", "170 kg", "180 kg", "190 kg", "200 kg", "210 kg", "220 kg", "230 kg", "240 kg", "250 kg", "260 kg", "270 kg", "280 kg", "290 kg", "300 kg")
    var array_grasa: Array<String> = arrayOf("10 %", "20 %", "30 %", "40 %", "50 %", "60 %", "70 %", "80 %", "90 %", "100 %")
    var array_altura: Array<String> = arrayOf("1.50 m", "1.55 m", "1.60 m", "1.65 m", "1.70 m", "1.75 m", "1.80 m", "1.85 m", "1.90 m", "1.95 m", "2.00 m", "2.05 m", "2.10 m", "2.15 m", "2.20 m")
    var array_edad: Array<String> = arrayOf("15 años" ,"16 años", "17 años", "18 años", "19 años", "20 años", "21 años", "22 años", "23 años", "24 años", "25 años", "26 años", "27 años", "28 años", "29 años", "30 años", "31 años", "32 años", "33 años", "34 años", "35 años", "36 años", "37 años", "38 años", "39 años", "40 años", "41 años", "42 años", "43 años", "44 años", "45 años", "46 años", "47 años", "48 años", "49 años", "50 años", "51 años", "52 años", "53 años", "54 años", "55 años", "56 años", "57 años", "58 años", "59 años", "60 años", "61 años", "62 años", "63 años", "64 años", "65 años", "66 años", "67 años", "68 años", "69 años", "70 años", "71 años", "72 años", "73 años", "74 años", "75 años", "76 años", "77 años", "78 años", "79 años", "80 años", "81 años", "82 años", "83 años", "84 años", "85 años", "86 años", "87 años", "88 años", "89 años", "90 años", "91 años", "92 años", "93 años", "94 años", "95 años", "96 años", "97 años", "98 años", "99 años", "100 años")
    var array_meta: Array<String> = arrayOf("Perder peso", "Ganar peso", "Mantener peso")



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enfoque = view.findViewById(R.id.otrasconfiguraciones_spinner_enfoquedelusuario)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_enfoque).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            enfoque.adapter = adapter
        }


        masa = view.findViewById(R.id.otrasconfiguraciones_spinner_masausuario)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_masa).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            masa.adapter = adapter
        }

        grasa = view.findViewById(R.id.otrasconfiguraciones_spinner_porcentajedegrasa)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_grasa).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            grasa.adapter = adapter
        }

        altura = view.findViewById(R.id.otrasconfiguraciones_spinner_alturaUsuario)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_altura).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            altura.adapter = adapter
        }

        edad = view.findViewById(R.id.otrasconfiguraciones_spinner_edadUsuario)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_edad).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            edad.adapter = adapter
        }

        meta = view.findViewById(R.id.otrasconfiguraciones_spinner_metaInicial)
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, array_meta).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            meta.adapter = adapter
        }

        btn.setOnClickListener{
            listeners()
        }


    }

    private fun getItemFromSpinner(spinner: Spinner): String {
        return spinner.selectedItem.toString()
    }

    private fun listeners(){

        opEnfoque = getItemFromSpinner(enfoque)
        opMasa = getItemFromSpinner(masa)
        opGrasa = getItemFromSpinner(grasa)
        opAltura = getItemFromSpinner(altura)
        opEdad = getItemFromSpinner(edad)
        opMeta = getItemFromSpinner(meta)

    }

}