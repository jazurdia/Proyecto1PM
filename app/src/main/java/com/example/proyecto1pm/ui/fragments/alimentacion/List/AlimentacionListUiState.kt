package com.example.proyecto1pm.ui.fragments.alimentacion.List

import com.example.proyecto1pm.Data.Remote.Dto.FoodDto

interface AlimentacionListUiState {
    data class Success(val foods: List<FoodDto>) : AlimentacionListUiState
    object Loading : AlimentacionListUiState
    object Default : AlimentacionListUiState
    data class Error(val message: String) : AlimentacionListUiState
}