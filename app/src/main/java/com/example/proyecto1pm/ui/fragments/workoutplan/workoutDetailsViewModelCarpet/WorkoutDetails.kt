package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsViewModelCarpet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.proyecto1pm.databinding.FragmentAlimentacionDetailsBinding
import com.example.proyecto1pm.databinding.FragmentWorkoutDetailsBinding
import com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet.WorkoutListArgs
import com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet.WorkoutListUiState
import com.example.proyecto1pm.ui.fragments.workoutplan.workoutListViewModelCarpet.WorkoutListViewModel


class WorkoutDetails: Fragment() {
    private val args : WorkoutListArgs by navArgs()
    private lateinit var binding: FragmentWorkoutDetailsBinding
    private val viewModel: WorkoutListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSingleWorkout(args.mamao)
        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.PublicUiState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state: WorkoutListUiState) {
        when(state){
            is WorkoutListUiState.SingleWSuccess ->{
                binding.constraintLayoutWorkoutDetails.visibility = View.VISIBLE
                binding.progressBarWorkoutDetails.visibility = View.GONE
                binding.textWorkoutName.text = state.entidadW.name
                binding.textWorkoutDescription.text = state.entidadW.description
                binding.textWorkoutReps.text = "Reps: "+state.entidadW.repetitions +" - Series: "+ state.entidadW.series


            }
            is WorkoutListUiState.Error ->{
                Toast.makeText(requireContext(),
                    state.message,
                    Toast.LENGTH_LONG).show()

            }
            WorkoutListUiState.Loading ->{
                binding.constraintLayoutWorkoutDetails.visibility = View.GONE
                binding.progressBarWorkoutDetails.visibility = View.VISIBLE

            }
            WorkoutListUiState.Default ->{
                binding.constraintLayoutWorkoutDetails.visibility = View.GONE
                binding.progressBarWorkoutDetails.visibility = View.GONE
            }
        }
    }

}