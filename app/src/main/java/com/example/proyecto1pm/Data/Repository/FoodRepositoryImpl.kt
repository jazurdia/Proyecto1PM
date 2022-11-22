package com.example.proyecto1pm.Data.Repository

import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import com.example.proyecto1pm.Data.Remote.Dto.FoodDto
import com.example.proyecto1pm.Data.Remote.Dto.toFoodEnt
import com.example.proyecto1pm.Data.Remote.NutricionixAPI
import com.example.proyecto1pm.Data.Resource

class FoodRepositoryImpl(
    val localDb: FoodDao,
    val api: NutricionixAPI
) : FoodRepository {
    override suspend fun getFoods(): Resource<List<FoodEnt>> {
        val localFood = localDb.getFood()
        try{
            if (localFood.isEmpty()) {
                val remoteFood = api.getFood().foods
                val mappedFoods = remoteFood.map {FoodDto -> FoodDto.toFoodEnt()}
                localDb.insertAll(mappedFoods)
                return Resource.Success(mappedFoods)
            }else {
                return Resource.Success(localFood)
            }
        }catch(ex: Exception){
            return Resource.Error(ex.message?:"")
        }
    }
}