package com.example.proyecto1pm.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FoodEnt(
    @PrimaryKey val food_name : String,
    val brand_name : String,
    val nf_calories : Double,
    val photo : String,
): java.io.Serializable