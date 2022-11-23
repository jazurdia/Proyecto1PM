package com.example.proyecto1pm.Data.Repository.Workout

import com.example.proyecto1pm.Data.Local.Dao.WorkoutDao
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.Data.Resource


class WorkoutRepositoryImpl(
    private val localDb: WorkoutDao
) : WorkoutRepository {

    override suspend fun getWorkouts() : Resource<List<WorkOutEnt>> {
        val localWorkout: List<WorkOutEnt> = localDb.getWorkOut()
        val mappedWorkout = localWorkout.map {WorkOutEnt -> WorkOutEnt}
        localDb.insertAll(mappedWorkout)
        return Resource.Success(mappedWorkout)
    }
}