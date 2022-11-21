package com.example.proyecto1pm.Data.database

import java.io.Serializable

data class Food(
    val name : String = "",
    val recipe : String = "",
    val image : String = "",
    val calories : String = "",
) : Serializable

object FoodData {
    private val foods = mutableListOf(
        Food(
            "Hamburguesa",
            "Paso 1\n" +
                    "\n" +
                    "Rallar la cebolla y picar el ajo. En un bol, mezclar la carne picada, la cebolla, el ajo y el huevo hasta que estén bien integrados todos los ingredientes.\n" +
                    "\n" +
                    "Paso 2\n" +
                    "\n" +
                    "Hacer  albóndigas con la mano y darles forma de hamburguesas.\n" +
                    "\n" +
                    "Paso 3\n" +
                    "\n" +
                    "Cocinar las hamburguesas de ambos lados en una sartén aceitada, hasta que estén bien marcadas.\n" +
                    "\n" +
                    "Paso 4\n" +
                    "\n" +
                    "Llevarlas a horno fuerte por 5 o 10 minutos hasta que estén completamente cocidas.\n" +
                    "\n" +
                    "Paso 5\n" +
                    "\n" +
                    "Armar las hamburguesas con los panes tibios, untar con el aderezo elegido, colocar la hamburguesa y los vegetales elegidos junto al queso cheddar.\n" +
                    "\n" +
                    "Paso 6\n" +
                    "\n" +
                    "Servir acompañadas de papas fritas. ",
            "https://www.clarin.com/img/2021/06/17/LC25eDtCT_1256x620__1.jpg",
            "300"
        ),
        Food(
            "Pizza",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://www.saborusa.com/wp-content/uploads/2019/10/Animate-a-disfrutar-una-deliciosa-pizza-de-salchicha-Foto-destacada.png",
            "300"
        ),
        Food(
            "Pasta",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://images.aws.nestle.recipes/resized/1828b2ea10adc8c9f710fcf959a55a51_PASTA-AL-ROMERO-Lunch_708_600.png",
            "300"
        ),
        Food(
            "Sushi",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://www.prensalibre.com/wp-content/uploads/2020/06/Sushi-1.jpg?quality=52",
            "300"
        ),
        Food(
            "Tacos",
            "1.  En un tazón, combinar la carne molida con sal, pimienta y dejar marinar 5 minutos.\n" +
                    "2.  En una cacerola a fuego alto, verter el aceite y sofreír el ajo y la cebolla hasta que estén dorados.\n" +
                    "3.  Poner a fuego medio, agregar la carne, la paprika, y cocinar por 10 minutos revolviendo constantemente.\n" +
                    "4.  En otro tazón, diluir la Crema de Tomate MAGGI® en el agua. Verter esta mezcla en la cacerola junto a la carne, revolver y cocinar por 15 minutos. Retirar del fuego y reservar.\n" +
                    "5.  En otro tazón, mezclar el tomate, la cebolla, el limón, el aceite, el cilantro, la sal, la pimienta y dejar marinar por 15 minutos en el refrigerador.\n" +
                    "6.  En un sartén a fuego alto, calentar las tortillas por ambos lados.\n" +
                    "7.  En cada tortilla, colocar 3 cucharadas de carne, 2 cucharadas de pico de gallo y 1 cucharada de Queso Americano NESTLÉ®",
            "https://www.pequerecetas.com/wp-content/uploads/2020/10/tacos-mexicanos-660x476.jpg.webp",
            "300"
        ),
        Food(
            "Tortas",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                    "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                    " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                    "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                    " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                    " amet.",
            "https://www.goya.com/media/4425/pork-poblano-and-roasted-pineapple-tortas.jpg?quality=80",
            "300"
        ),
    )

    fun getFoods() = foods
}