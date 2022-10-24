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
import com.example.proyecto1pm.Data.database.Food

class AdapterFood(private val dataSet: MutableList<Food>, private val listener: RecyclerViewFoodClickHandler) : RecyclerView.Adapter<AdapterFood.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_alimentacion, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }


    class ViewHolder(private val view: View, private val listener: RecyclerViewFoodClickHandler) : RecyclerView.ViewHolder(view) {

        private val imagen: ImageView = view.findViewById(R.id.image_recycler_food)
        private val name: TextView = view.findViewById(R.id.text_recycler_food_name)
        private val calories: TextView = view.findViewById(R.id.text_recycler_food_calories)
        private val layChar: ConstraintLayout = view.findViewById(R.id.recycler_item_alimentacion)

        fun setData(food: Food) {
            name.text = food.name
            calories.text = food.calories
            getImage(food.image)

            layChar.setOnClickListener() {
                listener.onWorkoutClicked(food)
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


    interface RecyclerViewFoodClickHandler {
        fun onWorkoutClicked(food: Food)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}