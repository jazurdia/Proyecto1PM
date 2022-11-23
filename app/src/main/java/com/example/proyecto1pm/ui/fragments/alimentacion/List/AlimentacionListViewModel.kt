package com.example.proyecto1pm.ui.fragments.alimentacion.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Repository.Food.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlimentacionListViewModel @Inject constructor (
    private val repository: FoodRepository
) : ViewModel() {
    private val PrivUiState : MutableStateFlow<AlimentacionListUiState> =
        MutableStateFlow(AlimentacionListUiState.Default)

    val PublicUiState: StateFlow<AlimentacionListUiState> = PrivUiState
    //State

    fun getFoods(){
        viewModelScope.launch {
            val Foods = repository.getFoods(Comida)

        }

        //Update state
    }
}