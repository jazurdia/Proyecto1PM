package com.example.proyecto1pm.Data.Local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import androidx.room.Dao

@Dao
interface FoodDao {
    @Query("SELECT * FROM food")
    fun getFood(): List<FoodEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(foods: List<FoodEnt>)

}