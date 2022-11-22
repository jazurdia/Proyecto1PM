package com.example.proyecto1pm.Data.Local

import androidx.room.Database
import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

@Database(
    entities = [FoodEnt::class],
    version = 1)

abstract class FoodsDb {

    abstract fun FoodDao(): FoodDao

}