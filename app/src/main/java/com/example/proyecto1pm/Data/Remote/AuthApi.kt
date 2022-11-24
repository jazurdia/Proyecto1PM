package com.example.proyecto1pm.Data.Remote

import com.example.proyecto1pm.Data.Resource

interface AuthApi {

    suspend fun singInFB(email: String, password: String): Resource<String>
    suspend fun singUpFB(email: String, password: String): Resource<String>

}