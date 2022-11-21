package com.example.proyecto1pm.Data.Repository

import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

interface FoodRepository {

    suspend fun getFoods(): List<FoodEnt>
}