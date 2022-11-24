package com.example.proyecto1pm.ui.fragments.user.loginMVVM

import android.view.View
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto1pm.Data.Repository.firebase.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginRegisterViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val PrivUiState : MutableStateFlow<LoginRegisterUiState> = MutableStateFlow(LoginRegisterUiState.Default)
    val PublicUiState: StateFlow<LoginRegisterUiState> = PrivUiState

    fun signIn(email: String, password : String){
        viewModelScope.launch{
            PrivUiState.value = LoginRegisterUiState.Loading
            delay(2000)
            val result = repository.singInFB(email, password)
            when(result){
                is com.example.proyecto1pm.Data.Resource.Error ->{
                    PrivUiState.value = LoginRegisterUiState.Error(result.message ?:"Ha ocurrido un error")
                }
                is com.example.proyecto1pm.Data.Resource.Success ->{
                    PrivUiState.value = LoginRegisterUiState.Success(result.data ?: "Usuario logeado")
                }
            }

        }
    }

    fun signUp(email: String, password : String){
        viewModelScope.launch{
            PrivUiState.value = LoginRegisterUiState.Loading
            delay(2000)
            val result = repository.singUpFB(email, password)
            when(result){
                is com.example.proyecto1pm.Data.Resource.Error ->{
                    PrivUiState.value = LoginRegisterUiState.Error(result.message ?:"Ha ocurrido un error")
                }
                is com.example.proyecto1pm.Data.Resource.Success ->{
                    PrivUiState.value = LoginRegisterUiState.Success(result.data ?: "Usuario registrado")
                }
            }

        }
    }


}