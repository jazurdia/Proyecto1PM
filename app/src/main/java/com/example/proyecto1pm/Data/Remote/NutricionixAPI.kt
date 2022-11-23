package com.example.proyecto1pm.Data.Remote

import com.example.proyecto1pm.Data.Remote.Dto.ResponseFoodDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NutricionixAPI {
    @Headers("Content-Type: application/json","x-app-id: 75f1ba8e", "x-app-key: 85db77dbf9acf4c7cf5544f30c59e5ac", "x-remote-user-id: Jskenpo" )
    @POST("/v2/natural/nutrients")
    suspend fun getFood(): ResponseFoodDto
}