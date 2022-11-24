package com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet

import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt

interface WorkoutListUiState {

    data class Success(val workouts : List<WorkOutEnt>) : WorkoutListUiState
    data class SingleWSuccess(val entidadW: WorkOutEnt) : WorkoutListUiState
    object Loading : WorkoutListUiState
    object Default : WorkoutListUiState
    data class Error(val message: String) : WorkoutListUiState

}