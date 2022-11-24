package com.example.proyecto1pm.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEnt (
    @PrimaryKey val email: String,
    val password : String,
) {
    fun isEmpty(): Boolean {

    }
}
