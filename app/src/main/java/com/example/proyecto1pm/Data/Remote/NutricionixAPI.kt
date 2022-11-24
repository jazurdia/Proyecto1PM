package com.example.proyecto1pm.Data.Remote

import com.example.proyecto1pm.Data.Remote.Dto.ComidasDto.ResponseFoodDto
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface NutricionixAPI {
    @Headers("Content-Type: application/json","x-app-id: 75f1ba8e", "x-app-key: 85db77dbf9acf4c7cf5544f30c59e5ac", "x-remote-user-id: Jskenpo" )
    @POST("/v2/natural/nutrients")
    suspend fun getFood(
        @Query("query")FoodsReq:String
    ): ResponseFoodDto
}