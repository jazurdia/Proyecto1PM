package com.example.proyecto1pm.Data.Local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import androidx.room.Dao
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import dagger.Provides


@Dao
interface WorkoutDao {


    @Query("SELECT * FROM WorkOutEnt")
    fun getWorkOut(): List<WorkOutEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(workouts: List<WorkOutEnt>)


    @Query("SELECT * FROM WorkOutEnt WHERE name =:name")
    suspend fun getUniqueWorkout(name: String) : WorkOutEnt
}