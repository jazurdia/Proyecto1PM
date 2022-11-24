package com.example.proyecto1pm.Data.Remote.Dto.EjerciciosDto

import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt

data class WorkoutDto(

    var name : String,
    var description : String,
    var image : String,
    var intensity : String,
    var repetitions : String,
    var series : String
)

fun WorkoutDto.toWorkoutEnt() = WorkOutEnt(
    name = name,
    description = description,
    image = image,
    intensity = intensity,
    repetitions = repetitions,
    series = series
)
