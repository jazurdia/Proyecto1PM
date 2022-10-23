package com.example.proyecto1pm.Data.database

import java.io.Serializable

data class Excersise(
    val name : String = "",
    val description : String = "",
    val image : String = "",
    val intensity : String = "",
    val repetitions : Int = 0,
    val series : Int = 0,
) : Serializable

object ExcersiseData {
    private val excersises = mutableListOf(
        Excersise(
            "Abdominales",
            "Abdominales",
            "https://www.vidasana.es/wp-content/uploads/2019/03/abdominales.jpg",
            "Baja",
            10,
            3
        ),
        Excersise(
            "Sentadillas",
            "Sentadillas",
            "https://www.vidasana.es/wp-content/uploads/2019/03/sentadillas.jpg",
            "Media",
            10,
            3
        ),
        Excersise(
            "Flexiones",
            "Flexiones",
            "https://www.vidasana.es/wp-content/uploads/2019/03/flexiones.jpg",
            "Alta",
            10,
            3
        ),
        Excersise(
            "Zancadas",
            "Zancadas",
            "https://www.vidasana.es/wp-content/uploads/2019/03/zancadas.jpg",
            "Media",
            10,
            3
        ),
        Excersise(
            "Plancha",
            "Plancha",
            "https://www.vidasana.es/wp-content/uploads/2019/03/plancha.jpg",
            "Baja",
            10,
            3
        ),
        Excersise(
            "Burpees",
            "Burpees",
            "https://www.vidasana.es/wp-content/uploads/2019/03/burpees.jpg",
            "Alta",
            10,
            3
        ),
        Excersise(
            "Peso muerto",
            "Peso muerto",
            "https://www.vidasana.es/wp-content/uploads/2019/03/peso-muerto.jpg",
            "Alta",
            10,
            3
        ),
        Excersise(
            "Peso muerto",
            "Peso muerto",
            "https://www.vidasana.es/wp-content/uploads/2019/03/peso-muerto.jpg",
            "Alta",
            10,
            3
        ),
        Excersise(
            "Peso muerto",
            "Peso muerto",
            "https://www.vidasana.es/wp-content/uploads/2019/03/peso-muerto.jpg",
        ),
    )

    fun getExcersises() = excersises
}