package com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.R

class AdapterWorkOut (
    private val workouts: List<WorkOutEnt>,
    private val placeListener : PlaceListener
    ) : RecyclerView.Adapter<AdapterWorkOut.ViewHolder>() {

        interface PlaceListener {
            fun onPlaceClicked(data: WorkOutEnt, position: Int)
            // la posición me servirá para saber que putas es en la db
        }

        class ViewHolder(
            private val view: View,
            private val listener: PlaceListener
        ) : RecyclerView.ViewHolder(view) {

            private val name: TextView = view.findViewById(R.id.text_recycler_workout_name)
            private val intensity : TextView = view.findViewById(R.id.text_recycler_workout_intensity)
            private val image : ImageView = view.findViewById(R.id.text_recycler_workout_image)
            private lateinit var place: WorkOutEnt


            fun setData(place: WorkOutEnt){
                this.place = place
                name.text = place.name
                intensity.text = place.intensity
                image.load(place.image) {
                    diskCachePolicy(CachePolicy.DISABLED)
                    memoryCachePolicy(CachePolicy.DISABLED)
                    error(R.drawable.ic_baseline_error_outline_24)
                    placeholder(R.drawable.ic_baseline_downloading_24)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_workout, parent, false)
            return ViewHolder(view, placeListener)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setData(workouts[position])
        }

    override fun getItemCount(): Int {
            return workouts.size
        }
}