package com.example.proyecto1pm.Data.Remote.Dto

import com.example.proyecto1pm.Data.Local.Entity.FoodEnt

data class FoodDto(
    val nix_item_id : String,
    val food_name : String,
    val brand_name : String,
    val nf_calories : Double,
    val photo : PhotoDto,
)

fun FoodDto.toFoodEnt() = FoodEnt(
    nix_item_id = nix_item_id,
    food_name = food_name,
    brand_name = brand_name,
    nf_calories = nf_calories,
    photo = photo.thumb,
)