package com.example.proyecto1pm.di

import android.content.Context
import androidx.room.Room
import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.Dao.WorkoutDao
import com.example.proyecto1pm.Data.Local.databases.FoodsDb
import com.example.proyecto1pm.Data.Local.databases.WorkoutDb
import com.example.proyecto1pm.Data.Repository.Workout.WorkoutRepository
import com.example.proyecto1pm.Data.Repository.Workout.WorkoutRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkoutModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        WorkoutDb::class.java,
        "workout_db"
    ).build()

    @Provides
    @Singleton
    fun provideWorkoutDao(database: WorkoutDb): WorkoutDao {
        return database.WorkoutDao()
    }

    @Provides
    @Singleton
    fun provideFakeRepository(dao: WorkoutDao): WorkoutRepository {
        return WorkoutRepositoryImpl(
            DaoWorkout = dao,
        )
    }


}