package com.example.proyecto1pm.ui.fragments.workoutplan.workoutDetailsVM

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentWorkoutDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutDetails : Fragment(R.layout.fragment_workout_details) {

    private lateinit var nombre : TextView
    private lateinit var descripcion : TextView
    private lateinit var reps : TextView
    private lateinit var imagen : ImageView
    private val args: WorkoutDetailsArgs by navArgs()


    private lateinit var binding : FragmentWorkoutDetailsBinding
    private val viewmodel : WorkoutDetailsViewModel by viewModels()


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

    private fun handleState(state: WorkoutDetailsUiState) {
        when(state){
            is WorkoutDetailsUiState.Success -> {
                binding.progressBarWorkoutDetails.visibility = View.GONE
                binding.constraintLayoutWorkoutDetails.visibility = View.VISIBLE
                binding.toolbarWorkoutDetails.visibility = View.VISIBLE
                binding.toolbarWorkoutDetails.title = state.workouts[0].nombre
                binding.nombreWorkoutDetails.text = state.workouts[0].nombre
                binding.descripcionWorkoutDetails.text = state.workouts[0].descripcion
                binding.repsWorkoutDetails.text = state.workouts[0].reps
                binding.imagenWorkoutDetails.load(state.workouts[0].imagen){
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                    error(R.drawable.ic_launcher_background)
                    memoryCachePolicy(CachePolicy.ENABLED)
                }
            }
        }

    }


}