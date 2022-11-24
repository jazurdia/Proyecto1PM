package com.example.proyecto1pm.Data.Local.firebase

import com.example.proyecto1pm.Data.Remote.AuthApi
import com.example.proyecto1pm.Data.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FireBaseAuhApiImpl : AuthApi {
    override suspend fun singInFB(email: String, password: String) : Resource<String> {

        try{

            val auth = Firebase.auth
            val response = auth.signInWithEmailAndPassword(email, password).await()
            val userInfo = response.user
            return if(userInfo != null) {
                Resource.Success(userInfo.uid)
            } else {
                Resource.Error("Error al iniciar sesion")
            }
        } catch (e: Exception){
            return Resource.Error(e.message ?: "Error al iniciar sesion")
        }

    }


}