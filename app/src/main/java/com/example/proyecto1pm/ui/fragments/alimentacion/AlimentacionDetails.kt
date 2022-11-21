package com.example.proyecto1pm.ui.fragments.alimentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import com.example.proyecto1pm.R


class AlimentacionDetails : Fragment(R.layout.fragment_alimentacion_details) {
    private lateinit var nombre : TextView
    private lateinit var descripcion : TextView
    private lateinit var imagen : ImageView
    private lateinit var calories : TextView
    private val args: AlimentacionDetailsArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagen = view.findViewById(R.id.image_food)
        nombre = view.findViewById(R.id.text_FoodName)
        descripcion = view.findViewById(R.id.text_FoodDescription)
        calories = view.findViewById(R.id.text_FoodCalories)
        getFood()
    }
    
    private fun getFood() {
        try{
        nombre.text = args.alimentacion.name //Aquí marta un error. "Unresolved reference: alimentacion"
        descripcion.text = args.alimentacion.recipe
        calories.text = args.alimentacion.calories + " calorías"
        getImage(args.alimentacion.image)
        }catch(e: Exception){
            println(e)
        }
    }

    private fun getImage(image: Any) {
        imagen.load(image) {
            error(R.drawable.ic_baseline_error_outline_24)
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
        }
    }

}