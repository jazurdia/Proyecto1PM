package com.example.proyecto1pm.di

import android.content.Context
import androidx.room.Room
import com.example.proyecto1pm.Data.Local.Dao.FoodDao
import com.example.proyecto1pm.Data.Local.FoodsDb
import com.example.proyecto1pm.Data.Remote.NutricionixAPI
import com.example.proyecto1pm.Data.Repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodAPi(client: OkHttpClient): NutricionixAPI {
        return Retrofit.Builder()
            .baseUrl("https://trackapi.nutritionix.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NutricionixAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(): FoodRepository {
        
    }
}