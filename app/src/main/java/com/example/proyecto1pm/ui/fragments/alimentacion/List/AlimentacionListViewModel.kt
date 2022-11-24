package com.example.proyecto1pm.ui.fragments.alimentacion.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import com.example.proyecto1pm.Data.Repository.Food.FoodRepository
import com.example.proyecto1pm.Data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    fun getFoods(food: String){
        viewModelScope.launch {
            PrivUiState.value = AlimentacionListUiState.Loading
            delay(2000)
            val FoodsResult = repository.getFoods(food)
            when(FoodsResult){
                is Resource.Error ->{
                    PrivUiState.value = AlimentacionListUiState.Error(FoodsResult.message ?:"")
                }
                is Resource.Success ->{
                    PrivUiState.value = AlimentacionListUiState.Success(FoodsResult.data ?: listOf())
                }
            }
        }
    }

    fun getUniqueFood(Comida: FoodEnt?){
        viewModelScope.launch {
            PrivUiState.value = AlimentacionListUiState.Loading
            delay(2000)
            val FoodsResult = repository.getUniqueFood(Comida!!)
            when(FoodsResult){
                is Resource.Error ->{
                    PrivUiState.value = AlimentacionListUiState.Error(FoodsResult.message ?:"")
                }
                is Resource.Success ->{
                    PrivUiState.value = AlimentacionListUiState.SingleSuccess(FoodsResult.data!!)
                }
            }
        }
    }
}