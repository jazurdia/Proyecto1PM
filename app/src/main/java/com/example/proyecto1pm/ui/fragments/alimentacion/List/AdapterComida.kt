package com.example.proyecto1pm.ui.fragments.alimentacion.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.example.proyecto1pm.Data.Local.Entity.FoodEnt
import com.example.proyecto1pm.Data.database.Food
import com.example.proyecto1pm.R
import okhttp3.internal.notify

class AdapterComida(
    private val dataSet: List<FoodEnt>,
    private val placeListener: PlaceListener
):
    RecyclerView.Adapter<AdapterComida.ViewHolder>() {

    interface PlaceListener {
        fun onPlaceClicked(data: FoodEnt, position: Int)
    }

    class ViewHolder(private val view: View,
                     private val listener: PlaceListener
    ) : RecyclerView.ViewHolder(view) {
        private val imageType: ImageView = view.findViewById(R.id.image_recycler_food)
        private val textName: TextView = view.findViewById(R.id.text_FoodName)
        private val textCaories: TextView = view.findViewById(R.id.text_recycler_food_calories)
        private val layout: ConstraintLayout = view.findViewById(R.id.recycler_item_alimentacion)
        private lateinit var place: FoodEnt

        fun setData(place: FoodEnt) {
            this.place = place
            textName.text = place.food_name
            textCaories.text = place.nf_calories.toString()

            imageType.load(place.photo) {
                diskCachePolicy(CachePolicy.DISABLED)
                memoryCachePolicy(CachePolicy.DISABLED)
                error(R.drawable.ic_baseline_error_outline_24)
                placeholder(R.drawable.ic_baseline_downloading_24)
            }
            setListeners()
        }

        private fun setListeners() {
            layout.setOnClickListener {
                listener.onPlaceClicked(place, this.adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_alimentacion, parent, false)

        return ViewHolder(view, placeListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}