package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Remote.Dto.WorkoutDto
import com.example.proyecto1pm.Data.Repository.Workout.WorkoutRepository
import com.example.proyecto1pm.Data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WorkoutDetailsViewModel @Inject constructor(
    private val repository: WorkoutRepository
) : ViewModel() {
    private val PrivUiState : MutableStateFlow<WorkoutDetailsUiState> =
        MutableStateFlow(WorkoutDetailsUiState.Default)

    val PublicUiState: StateFlow<WorkoutDetailsUiState> = PrivUiState
    //State

    fun getWorkouts(){
        viewModelScope.launch {

            PrivUiState.value = WorkoutDetailsUiState.Loading
            delay(2000)
            val WorkoutsResult = repository.getWorkouts()
            when(WorkoutsResult){
                is Resource.Error ->{
                    PrivUiState.value = WorkoutDetailsUiState.Error(WorkoutsResult.message ?:"")
                }
                is Resource.Success ->{
                    PrivUiState.value = WorkoutDetailsUiState.Success((WorkoutsResult.data ?: listOf()) as List<WorkoutDto>)
                }
            }


        }
        //Update state
    }
}
