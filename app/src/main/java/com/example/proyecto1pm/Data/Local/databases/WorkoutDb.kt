package com.example.proyecto1pm.Data.Local.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto1pm.Data.Local.Dao.WorkoutDao
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt


@Database(
    entities = [WorkOutEnt::class],
    version = 1)

abstract class WorkoutDb : RoomDatabase() {
    abstract fun WorkoutDao(): WorkoutDao
}