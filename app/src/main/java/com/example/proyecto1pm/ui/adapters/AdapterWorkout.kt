package com.example.proyecto1pm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1pm.R
import com.example.proyecto1pm.Data.Local.database.Excersise

class AdapterWorkout(private val dataSet: MutableList<Excersise>, private val listener: RecyclerViewWorkoutClickHandler) : RecyclerView.Adapter<AdapterWorkout.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_workout, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }


    class ViewHolder(private val view: View, private val listener: RecyclerViewWorkoutClickHandler) : RecyclerView.ViewHolder(view) {

        private val imagen: ImageView = view.findViewById(R.id.image_recycler_workout)
        private val name: TextView = view.findViewById(R.id.text_recycler_workout_name)
        private val intensity: TextView = view.findViewById(R.id.text_recycler_workout_intensity)
        private val layChar: ConstraintLayout = view.findViewById(R.id.recycler_item_workout)

        fun setData(exercise: Excersise) {
            name.text = exercise.name
            intensity.text = exercise.intensity
            getImage(exercise.image)

            layChar.setOnClickListener() {
                listener.onWorkoutClicked(exercise)
            }
        }

        private fun getImage(image: String) {
            imagen.load(image) {
                transformations(CircleCropTransformation())
                error(R.drawable.ic_baseline_error_outline_24)
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }

    }


    interface RecyclerViewWorkoutClickHandler {
        fun onWorkoutClicked(excersise: Excersise)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}