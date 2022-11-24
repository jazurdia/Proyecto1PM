package com.example.proyecto1pm.ui.fragments.alimentacion.List

import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

interface AlimentacionListUiState {
    data class Success(val foods: List<FoodEnt>?) : AlimentacionListUiState
    data class SingleSuccess(val entidad: FoodEnt): AlimentacionListUiState
    object Loading : AlimentacionListUiState
    object Default : AlimentacionListUiState
    data class Error(val message: String) : AlimentacionListUiState
}