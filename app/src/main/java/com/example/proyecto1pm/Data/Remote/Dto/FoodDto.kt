package com.example.proyecto1pm.Data.Remote.Dto

data class FoodDto(
    val nix_item_id : String,
    val food_name : String,
    val brand_name : String,
    val nf_calories : Double,
    val photo : PhotoDto,
)
