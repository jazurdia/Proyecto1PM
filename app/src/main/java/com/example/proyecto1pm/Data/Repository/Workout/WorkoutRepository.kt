package com.example.proyecto1pm.Data.Repository.Workout

import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.Data.Resource

interface WorkoutRepository {

    suspend fun getWorkouts(WorkoutsReq:String): Resource<List<WorkOutEnt>>

}

