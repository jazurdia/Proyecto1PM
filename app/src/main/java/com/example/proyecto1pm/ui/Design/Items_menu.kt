package com.example.proyecto1pm.ui.Design

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String,

){
    object Home : Items_menu(
        R.drawable.ic_baseline_home_24,
        "Home",
        "Home"
    )
    object Alimentacion : Items_menu(
        R.drawable.ic_baseline_fastfood_24,
        "Alimentación",
        "Alimentacion"
    )
    object Ejercicio : Items_menu(
        R.drawable.ic_baseline_directions_run_24,
        "Ejercicio",
        "Ejercicio"
    )
    object Perfil : Items_menu(
        R.drawable.ic_baseline_person_24,
        "Perfil",
        "Perfil"
    )
    object Salir : Items_menu(
        R.drawable.ic_baseline_exit_to_app_24,
        "Salir",
        "Salir"
    )
}
