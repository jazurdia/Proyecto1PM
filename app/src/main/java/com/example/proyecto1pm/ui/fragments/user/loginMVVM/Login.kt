package com.example.proyecto1pm.ui.fragments.user.loginMVVM

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.proyecto1pm.Data.Local.firebase.FireBaseAuhApiImpl
import com.example.proyecto1pm.Data.Repository.firebase.AuthRepository
import com.example.proyecto1pm.Data.Repository.firebase.AuthRepositoryImpl
import com.example.proyecto1pm.R
import com.example.proyecto1pm.databinding.FragmentLoginBinding



class Login : Fragment(R.layout.fragment_login) {

    private lateinit var authRepository: AuthRepository
    private lateinit var viewModel: LoginRegisterViewModel
    private lateinit var binding : FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        authRepository = AuthRepositoryImpl(FireBaseAuhApiImpl())
        viewModel = LoginRegisterViewModel(authRepository)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        setObservers()

    }

    private fun setListeners() {
        // sign in
        binding.loginContinuarbtn.setOnClickListener {
            val email = binding.loginEmail.editText?.text.toString()
            val password = binding.loginPassword.editText?.text.toString()
            viewModel.signIn(email, password)

        }

        // sign up
        binding.loginSignupbtn.setOnClickListener {
            val email = binding.loginEmail.editText?.text.toString()
            val password = binding.loginPassword.editText?.text.toString()
            viewModel.signUp(email, password)
        }

    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.PublicUiState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state : LoginRegisterUiState){
        when(state){
            is LoginRegisterUiState.Success -> {
                findNavController().navigate(LoginDirections.actionLoginToWorkoutList())
                //binding.progressBarLogin.visibility = View.GONE

            } is LoginRegisterUiState.Loading -> {
                //binding.progressBarLogin.visibility = View.VISIBLE

            } is LoginRegisterUiState.Error -> {
                Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                //binding.progressBarLogin.visibility = View.GONE

            }
        }
    }
}