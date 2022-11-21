package com.example.proyecto1pm.ui.fragments.workoutplan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1pm.Data.database.Excersise
import com.example.proyecto1pm.Data.database.ExcersiseData
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentWorkoutListBinding
import com.example.proyecto1pm.ui.adapters.AdapterWorkout
import androidx.navigation.findNavController


class WorkoutList : Fragment(R.layout.fragment_workout_list), AdapterWorkout.RecyclerViewWorkoutClickHandler {

    private lateinit var recycler: RecyclerView
    private lateinit var list: MutableList<Excersise>
    private lateinit var adapter: AdapterWorkout

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            recycler = view.findViewById(R.id.recycler_workouts)
            initRecycler()
        }

    private fun initRecycler() {
        list = ExcersiseData.getExcersises()
        adapter = AdapterWorkout(list, this)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter
    }

    override fun onWorkoutClicked(excersise: Excersise) {
        //navigate with nav controller
        val action = WorkoutListDirections.actionWorkoutListToWorkoutDetails(excersise)
        requireView().findNavController().navigate(action)


    }


}

