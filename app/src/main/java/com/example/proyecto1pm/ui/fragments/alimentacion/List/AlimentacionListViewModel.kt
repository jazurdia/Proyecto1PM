package com.example.proyecto1pm.ui.fragments.alimentacion.List

import androidx.lifecycle.ViewModel
import com.example.proyecto1pm.Data.Repository.FoodRepository



class AlimentacionListViewModel (
    private val repository: FoodRepository
) : ViewModel() {

    fun getFoods() = repository.getFoods()
}