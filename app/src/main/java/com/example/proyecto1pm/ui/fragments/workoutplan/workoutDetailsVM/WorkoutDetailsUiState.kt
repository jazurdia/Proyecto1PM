package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsVM

import com.example.proyecto1pm.Data.Remote.Dto.WorkoutDto

interface WorkoutDetailsUiState {

    data class Success(val workouts : List<WorkoutDto>) : WorkoutDetailsUiState
    object Loading : WorkoutDetailsUiState
    object Default : WorkoutDetailsUiState
    data class Error(val message: String) : WorkoutDetailsUiState

}