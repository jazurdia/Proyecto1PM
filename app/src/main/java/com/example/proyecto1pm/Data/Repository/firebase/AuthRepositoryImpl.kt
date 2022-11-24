package com.example.proyecto1pm.Data.Repository.firebase

import com.example.proyecto1pm.Data.Local.Dao.userDao
import com.example.proyecto1pm.Data.Remote.AuthApi
import com.example.proyecto1pm.Data.Resource

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val localDb: userDao
) : AuthRepository {
    override suspend fun singInFB(email: String, password: String): Resource<String> {
        val localUser = localDb.getUser()
        try{
            if (localUser.isEmpty()) {
                val remoteUser = authApi.singInFB(email, password)
                localDb.insertAll(remoteUser)
                return Resource.Success
            }else {
                return Resource.Success(localUser)
            }

    }

