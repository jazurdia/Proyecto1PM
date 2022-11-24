package com.example.proyecto1pm.Data.Repository.firebase

import com.example.proyecto1pm.Data.Remote.AuthApi
import com.example.proyecto1pm.Data.Resource

class AuthRepositoryImpl(
    private val authApi: AuthApi,
) : AuthRepository {
    override suspend fun singInFB(email: String, password: String): Resource<String> {

        val localUser = authApi.singInFB(email, password)
        return localUser

    }

    override suspend fun singUpFB(email: String, password: String): Resource<String> {
        val localUser = authApi.singUpFB(email, password)
        return localUser
    }

}

