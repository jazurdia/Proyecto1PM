package com.example.proyecto1pm.Data.Remote.Dto.ComidasDto

import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

data class FoodDto(
    val food_name : String,
    val brand_name : String,
    val nf_calories : Double,
    val photo : PhotoDto,
)

fun FoodDto.toFoodEnt() = FoodEnt(
    food_name = food_name,
    brand_name = brand_name,
    nf_calories = nf_calories,
    photo = photo.thumb,
)