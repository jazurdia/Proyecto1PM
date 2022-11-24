package com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.toMutableStateList
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentWorkoutListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutList : Fragment(), AdapterWorkOut.PlaceListener  {

    private lateinit var binding : FragmentWorkoutListBinding
    private val viewmodel : WorkoutListViewModel by viewModels()
    private lateinit var listOfWorkouts : MutableList<WorkOutEnt>



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewmodel.getWorkouts()
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewmodel.PublicUiState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state: WorkoutListUiState) {
        when(state){
            is WorkoutListUiState.Success -> {
                listOfWorkouts = state.workouts.toMutableStateList()
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.VISIBLE
                binding.recyclerWorkouts.setHasFixedSize(true)
                binding.recyclerWorkouts.layoutManager = LinearLayoutManager(context)
                binding.recyclerWorkouts.adapter = AdapterWorkOut(listOfWorkouts,this)
                binding.recyclerWorkouts.adapter?.notifyDataSetChanged()


            } is WorkoutListUiState.Loading -> {
                binding.progressBarWorkoutList.visibility = View.VISIBLE
                binding.recyclerWorkouts.visibility = View.GONE
            } is WorkoutListUiState.Error -> {
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.GONE

                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()

            } is WorkoutListUiState.Default -> {
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.GONE
            }

        }

    }

    override fun onPlaceClicked(data: WorkOutEnt, position: Int) {
        requireView().findNavController().navigate(WorkoutListDirections.actionWorkoutListToWorkoutDetails(data))
    }


}