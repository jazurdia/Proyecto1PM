package com.example.proyecto1pm.Data.Repository.Food

import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import com.example.proyecto1pm.Data.Remote.Dto.toFoodEnt
import com.example.proyecto1pm.Data.Remote.NutricionixAPI
import com.example.proyecto1pm.Data.Resource

class FoodRepositoryImpl(
    private val localDb: FoodDao,
    private val api: NutricionixAPI
) : FoodRepository {
    override suspend fun getFoods(FoodReq :String): Resource<List<FoodEnt>?> {
        val localFood = localDb.getFood()
        try{
            if (localFood.isEmpty()) {
                val remoteFood = api.getFood(FoodReq).foods
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

    override suspend fun getUniqueFood(Food: FoodEnt): Resource<FoodEnt?> {
        return try{
            val localUnique = localDb.getUniqueFood(Food.food_name)
            if(localUnique!= null){
                Resource.Success(localUnique)
            }else{
                Resource.Error("No se encontró base de datos local")
            }
        }catch(ex: Exception){
            Resource.Error(ex.message?:"Error inesperado")
        }

    }
}