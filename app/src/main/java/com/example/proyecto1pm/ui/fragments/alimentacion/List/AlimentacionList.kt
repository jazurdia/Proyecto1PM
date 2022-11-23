package com.example.proyecto1pm.ui.fragments.alimentacion.List

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1pm.Data.database.Food
import com.example.proyecto1pm.Data.database.FoodData
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentAlimentacionListBinding
import com.example.proyecto1pm.ui.adapters.AdapterFood
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlimentacionList : Fragment(){
    private lateinit var binding : FragmentAlimentacionListBinding
    private val viewModel : AlimentacionListViewModel by viewModels()
    private lateinit var FoodReq: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlimentacionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FoodReq = binding.inputLayoutAlimantacionListFragment.toString()
        setObservers()
        viewModel.getFoods()

    }



    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.PublicUiState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state: AlimentacionListUiState){
        when(state){
            is AlimentacionListUiState.Success -> {
                binding.recyclerAlimentacion.visibility = View.VISIBLE
                binding.progressBarAlimentacionList.visibility = View.GONE
                binding.toolbarAlimentacionList.visibility = View.VISIBLE
                binding.constraintLayoutCalories.visibility = View.VISIBLE
            }
            is AlimentacionListUiState.Error -> {
                //Show error
                binding.recyclerAlimentacion.visibility = View.GONE
                binding.progressBarAlimentacionList.visibility = View.GONE
                binding.toolbarAlimentacionList.visibility = View.GONE
                binding.constraintLayoutCalories.visibility = View.GONE
                Toast.makeText(requireContext(),
                    state.message,
                    Toast.LENGTH_LONG).show()

            }
            AlimentacionListUiState.Loading -> {4
                binding.recyclerAlimentacion.visibility = View.GONE
                binding.progressBarAlimentacionList.visibility = View.VISIBLE
                binding.toolbarAlimentacionList.visibility = View.GONE
                binding.constraintLayoutCalories.visibility = View.GONE
            }
            AlimentacionListUiState.Default -> {
                binding.recyclerAlimentacion.visibility = View.GONE
                binding.progressBarAlimentacionList.visibility = View.GONE
                binding.toolbarAlimentacionList.visibility = View.GONE
                binding.constraintLayoutCalories.visibility = View.GONE
            }
        }
    }


}
