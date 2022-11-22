package com.example.proyecto1pm.ui.fragments.alimentacion.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1pm.Data.database.Food
import com.example.proyecto1pm.Data.database.FoodData
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
            requireActivity().findViewById<View>(R.id.bottom_navigation).visibility = View.VISIBLE
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
        // PABLO ESTO TAMBIEN LO CAMBIE.
        val action = AlimentacionListDirections.actionAlimentacionList3ToAlimentacionDetails(food)
        requireView().findNavController().navigate(action)
    }


}
