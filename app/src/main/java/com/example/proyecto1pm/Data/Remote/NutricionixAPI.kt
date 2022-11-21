package com.example.proyecto1pm.Data.Remote

import com.example.proyecto1pm.Data.Remote.Dto.ResponseFoodDto
import retrofit2.http.GET

interface NutricionixAPI {
    @GET("/v2/natural/nutrients")
    suspend fun getFood(): ResponseFoodDto
}