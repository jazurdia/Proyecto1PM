package com.example.proyecto1pm.Data.Local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import androidx.room.Dao
import dagger.Provides

@Dao
interface FoodDao {

    @Query("SELECT * FROM FoodEnt")
    suspend fun getFood(): List<FoodEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(foods: List<FoodEnt>)


    @Query("SELECT * FROM FoodEnt WHERE food_name =:name")
    suspend fun getUniqueFood(name: String) : FoodEnt

}