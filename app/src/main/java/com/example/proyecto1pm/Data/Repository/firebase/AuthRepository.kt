package com.example.proyecto1pm.Data.Repository.firebase

import com.example.proyecto1pm.Data.Resource

interface AuthRepository {

    suspend fun singInFB(email: String, password: String): Resource<String>
    suspend fun singUpFB(email: String, password: String): Resource<String>

}