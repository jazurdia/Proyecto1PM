package com.example.proyecto1pm.Data.Local.firebase

import com.example.proyecto1pm.Data.Remote.AuthApi
import com.example.proyecto1pm.Data.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FireBaseAuhApiImpl : AuthApi {
    override suspend fun singInFB(email: String, password: String) : Resource<String> {

        try {
            val auth = Firebase.auth
            if (email.isNotEmpty() && password.isNotEmpty()) {
                val result = auth.signInWithEmailAndPassword(email, password).await()
                if (result.user != null) {
                    return Resource.Success(result.user!!.uid)
                } else {
                    return Resource.Error("Error al iniciar sesion")
                }
            } else {
                return Resource.Error("Error al iniciar sesion")
            }

        } catch (e: Exception) {
            return Resource.Error("Error desconocido")
        }
    }

    override suspend fun singUpFB(email: String, password: String): Resource<String> {
        try {
            val auth = Firebase.auth
            if (email.isNotEmpty() && password.isNotEmpty()) {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                if (result.user != null) {
                    return Resource.Success(result.user!!.uid)
                } else {
                    return Resource.Error("Error al iniciar sesion")
                }
            } else {
                return Resource.Error("Error al iniciar sesion")
            }

        } catch (e: Exception) {
            return Resource.Error("Error desconocido")
        }
    }


}