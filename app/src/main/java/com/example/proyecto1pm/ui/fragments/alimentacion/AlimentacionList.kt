package com.example.proyecto1pm.ui.fragments.alimentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1pm.Data.Local.database.Food
import com.example.proyecto1pm.Data.Local.database.FoodData
import com.example.proyecto1pm.R
import com.example.proyecto1pm.ui.adapters.AdapterFood


class AlimentacionList : Fragment(R.layout.fragment_alimentacion_list), AdapterFood.RecyclerViewFoodClickHandler {

    private lateinit var recycler: RecyclerView
    private lateinit var list: MutableList<Food>
    private lateinit var adapter: AdapterFood

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            recycler = view.findViewById(R.id.recycler_alimentacion)
            initRecycler()
        }

    private fun initRecycler() {
        list = FoodData.getFoods()
        adapter = AdapterFood(list, this)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter
    }

    override fun onFoodClicked(food: Food) {
        //navigate with nav controller
        val action = AlimentacionListDirections.actionAlimentacionListToAlimentacionDetails(food)
        view?.findNavController()?.navigate(action)
    }


}
