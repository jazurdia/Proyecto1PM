package com.example.proyecto1pm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto1pm.R


class Login : Fragment(R.layout.fragment_login) {


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            requireActivity().findViewById<View>(R.id.bottom_navigation).visibility = View.GONE
        }

}