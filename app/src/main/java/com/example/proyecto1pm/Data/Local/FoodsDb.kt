package com.example.proyecto1pm.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

@Database(
    entities = [FoodEnt::class],
    version = 1)

abstract class FoodsDb: RoomDatabase() {
    abstract fun FoodDao(): FoodDao
}