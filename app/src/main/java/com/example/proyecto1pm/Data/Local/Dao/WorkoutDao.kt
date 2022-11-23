package com.example.proyecto1pm.Data.Local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import androidx.room.Dao


@Dao
interface WorkoutDao {

    @Query("SELECT * FROM WorkOutEnt")
    fun getWorkOut(): List<WorkOutEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(workouts: List<WorkOutEnt>)

}