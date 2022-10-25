package com.example.proyecto1pm.ui.fragments.workoutplan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import com.example.proyecto1pm.R


class WorkoutDetails : Fragment(R.layout.fragment_workout_details) {

    private lateinit var nombre : TextView
    private lateinit var descripcion : TextView
    private lateinit var reps : TextView
    private lateinit var imagen : ImageView
    private val args: WorkoutDetailsArgs by navArgs()


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            imagen = view.findViewById(R.id.image_workout)
            nombre = view.findViewById(R.id.text_workoutName)
            descripcion = view.findViewById(R.id.text_workoutSteps)
            reps = view.findViewById(R.id.text_workoutReps)
            getExercise()
        }

    private fun getExercise() {
        nombre.text = args.workout.name
        descripcion.text = args.workout.description
        reps.text = args.workout.repetitions + " reps x " + args.workout.series + "series"
        getImage(args.workout.image)
    }

    private fun getImage(image: String) {
        imagen.load(image) {
            error(R.drawable.ic_baseline_error_outline_24)
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
        }

    }


}