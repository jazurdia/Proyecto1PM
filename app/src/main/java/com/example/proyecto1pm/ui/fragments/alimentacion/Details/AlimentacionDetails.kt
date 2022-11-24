package com.example.proyecto1pm.ui.fragments.alimentacion.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.proyecto1pm.databinding.FragmentAlimentacionDetailsBinding
import com.example.proyecto1pm.ui.fragments.alimentacion.List.AlimentacionListUiState
import com.example.proyecto1pm.ui.fragments.alimentacion.List.AlimentacionListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlimentacionDetails : Fragment() {
    private val args: AlimentacionDetailsArgs by navArgs()
    private lateinit var binding: FragmentAlimentacionDetailsBinding
    private val viewModel : AlimentacionListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlimentacionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUniqueFood(args.comidita)
        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.PublicUiState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state: AlimentacionListUiState) {
        when(state){
            is AlimentacionListUiState.SingleSuccess -> {
                binding.constraintLayoutDetails.visibility = View.VISIBLE
                binding.ProgressBarAlimentacionDetails.visibility = View.GONE
                binding.textFoodCalories.text = state.entidad.nf_calories.toString()
                binding.textFoodName.text = state.entidad.food_name
            }
            is AlimentacionListUiState.Error -> {
                //Show error
                binding.constraintLayoutDetails.visibility = View.GONE
                binding.ProgressBarAlimentacionDetails.visibility = View.GONE
                Toast.makeText(requireContext(),
                    state.message,
                    Toast.LENGTH_LONG).show()

            }
            AlimentacionListUiState.Loading -> {
                binding.constraintLayoutDetails.visibility = View.GONE
                binding.ProgressBarAlimentacionDetails.visibility = View.VISIBLE

            }
            AlimentacionListUiState.Default -> {
                binding.constraintLayoutDetails.visibility = View.GONE
                binding.ProgressBarAlimentacionDetails.visibility = View.GONE

            }
        }
    }


    private fun getImage(image: Any) {

    }

}