package com.example.proyecto1pm.di

import android.content.Context
import androidx.room.Room
import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.FoodsDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoodModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        FoodsDb::class.java,
        "foods_db"
    ).build()

    @Provides
    @Singleton
    fun provideFoodDao(database: FoodsDb): FoodDao {
        return database.FoodDao()
    }
}