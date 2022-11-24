package com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.Data.Repository.Workout.WorkoutRepository
import com.example.proyecto1pm.Data.Resource
import com.example.proyecto1pm.ui.fragments.alimentacion.List.AlimentacionListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val repository: WorkoutRepository
) : ViewModel() {
    private val PrivUiState : MutableStateFlow<WorkoutListUiState> =
        MutableStateFlow(WorkoutListUiState.Default)

    val PublicUiState: StateFlow<WorkoutListUiState> = PrivUiState
    //State

    fun getWorkouts(){
        viewModelScope.launch {

            PrivUiState.value = WorkoutListUiState.Loading
            delay(2000)
            val WorkoutsResult = repository.getWorkouts()
            when(WorkoutsResult){
                is Resource.Error ->{
                    PrivUiState.value = WorkoutListUiState.Error(WorkoutsResult.message ?:"")
                }
                is Resource.Success ->{
                    PrivUiState.value = WorkoutListUiState.Success((WorkoutsResult.data ?: listOf()))
                }
            }


        }
        //Update state
    }

    fun getSingleWorkout(Ejercicio : WorkOutEnt?){
        viewModelScope.launch {
            PrivUiState.value = WorkoutListUiState.Loading
            delay(2000)
            val FoodsResult = repository.getUniqueWorkout(Ejercicio!!)
            when(FoodsResult){
                is Resource.Error ->{
                    PrivUiState.value = WorkoutListUiState.Error(FoodsResult.message ?:"")
                }
                is Resource.Success ->{
                    PrivUiState.value = WorkoutListUiState.SingleWSuccess(FoodsResult.data!!)
                }
            }
        }

    }
}
