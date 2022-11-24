package com.example.proyecto1pm.ui.fragments.user.loginMVVM

interface LoginRegisterUiState {

    data class Success(val message: String) : LoginRegisterUiState
    object Loading : LoginRegisterUiState
    object Default : LoginRegisterUiState
    data class Error(val message: String) : LoginRegisterUiState

}