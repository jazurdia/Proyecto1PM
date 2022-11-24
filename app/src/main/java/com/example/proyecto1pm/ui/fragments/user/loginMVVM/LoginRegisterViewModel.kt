package com.example.proyecto1pm.ui.fragments.user.loginMVVM

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Repository.firebase.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginRegisterViewModel: ViewModel() {

    private val repository = AuthRepository

    private val PrivUiState: MutableStateFlow<LoginRegisterUiState> = MutableStateFlow<LoginRegisterUiState>(LoginRegisterUiState.Default)
    val PublicUiState: StateFlow<LoginRegisterUiState> = PrivUiState

    fun login(email: String, password: String){
        viewModelScope.launch {
            PrivUiState.value = LoginRegisterUiState.Loading
            delay(2000)




        }
    }







}