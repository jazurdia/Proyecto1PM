package com.example.proyecto1pm.Data.Local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1pm.Data.Local.Entity.UserEnt
import com.example.proyecto1pm.Data.Resource

interface userDao {

    @Query("SELECT * FROM UserEnt")
    fun getUser(): UserEnt

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: Resource<String>)

}