package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsVM

import com.example.proyecto1pm.Data.Remote.Dto.WorkoutDto

interface WorkoutListUiState {

    data class Success(val workouts : List<WorkoutDto>) : WorkoutListUiState
    object Loading : WorkoutListUiState
    object Default : WorkoutListUiState
    data class Error(val message: String) : WorkoutListUiState

}