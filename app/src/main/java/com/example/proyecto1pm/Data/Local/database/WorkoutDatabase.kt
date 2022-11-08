package com.example.proyecto1pm.Data.Local.database

import java.io.Serializable

data class Excersise(
    val name : String = "",
    val description : String = "",
    val image : String = "",
    val intensity : String = "",
    val repetitions : String = "0",
    val series : String = "0",
) : Serializable

object ExcersiseData {
    private val excersises = mutableListOf(
        Excersise(
            "Abdominales",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://us.123rf.com/450wm/artinspiring/artinspiring1903/artinspiring190300192/124762338-hombre-haciendo-abdominales-en-el-gimnasio-entrenamiento-para-quemar-el-vientre-guy-hace-ejercicio-e.jpg?ver=6",
            "Baja",
            "10",
            "3"
        ),
        Excersise(
            "Sentadillas",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://rutinaejercicio.com/wp-content/uploads/2018/12/137.gif",
            "Media",
            "10",
            "3"
        ),
        Excersise(
            "Flexiones",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://us.123rf.com/450wm/robuart/robuart1810/robuart181001369/109565479-posici%C3%B3n-de-flexiones-de-yoga-mujer-en-forma-con-fuerza-en-los-brazos-hace-ejercicios-la-dama-usa-il.jpg",
            "Alta",
            "10",
            "3"
        ),
        Excersise(
            "Zancadas",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://rutinaejercicio.com/wp-content/uploads/2018/12/135.gif",
            "Media",
            "10",
            "3"
        ),
        Excersise(
            "Plancha",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://static.vecteezy.com/system/resources/previews/005/906/676/original/woman-doing-plank-hip-dips-exercise-flat-illustration-isolated-on-white-background-free-vector.jpg",
            "Baja",
            "10",
            "3"
        ),
        Excersise(
            "Burpees",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://us.123rf.com/450wm/lioputra/lioputra2010/lioputra201000163/157833604-gu%C3%ADa-de-ejercicios-con-un-hombre-haciendo-la-posici%C3%B3n-squat-thrust-burpee-en-3-pasos-ilustraci%C3%B3n-sob.jpg?ver=6",
            "Alta",
            "10",
            "3"
        ),
        Excersise(
            "Peso muerto",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://media.istockphoto.com/vectors/man-doing-barbell-stiff-leg-deadlift-exercise-flat-vector-isolated-vector-id1408890976?k=20&m=1408890976&s=612x612&w=0&h=XrARt2xQAw-zgODcgyVVf65OTSDqpt3tf8HP3Q3TBRU=",
            "Alta",
            "10",
            "3"
        ),
    )

    fun getExcersises() = excersises
}