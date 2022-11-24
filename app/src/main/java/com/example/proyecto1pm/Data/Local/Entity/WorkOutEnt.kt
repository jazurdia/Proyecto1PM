package com.example.proyecto1pm.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkOutEnt(
    @PrimaryKey val name : String,
    val description : String,
    val image : String,
    val intensity : String,
    val repetitions : String,
    val series : String,
): java.io.Serializable
