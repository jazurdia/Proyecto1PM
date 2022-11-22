package com.example.proyecto1pm.Data.Repository

import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import com.example.proyecto1pm.Data.Resource

interface FoodRepository {

    suspend fun getFoods(): Resource<List<FoodEnt>>
}