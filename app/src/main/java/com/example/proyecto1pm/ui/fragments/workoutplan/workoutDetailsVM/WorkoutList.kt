package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsVM

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentWorkoutListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutList : Fragment(R.layout.fragment_workout_list) {

    private lateinit var binding : FragmentWorkoutListBinding
    private val viewmodel : WorkoutListViewModel by viewModels()


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
        viewmodel.getWorkouts() // revisar esto.
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
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.toolbarWorkoutList.visibility = View.VISIBLE
                binding.recyclerWorkouts.visibility = View.VISIBLE

            } is WorkoutListUiState.Loading -> {
                binding.progressBarWorkoutList.visibility = View.VISIBLE
                binding.toolbarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.GONE
            } is WorkoutListUiState.Error -> {
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.toolbarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.GONE

                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()

            } is WorkoutListUiState.Default -> {
                binding.progressBarWorkoutList.visibility = View.GONE
                binding.toolbarWorkoutList.visibility = View.GONE
                binding.recyclerWorkouts.visibility = View.GONE
            }

        }

    }


}