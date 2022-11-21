package com.example.proyecto1pm.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.proyecto1pm.Data.Remote.Dto.PhotoDto

@Entity
data class Food(
     @PrimaryKey val food_name : String,
    val brand_name : String,
    val nf_calories : Double,
    val photo : String,
)
