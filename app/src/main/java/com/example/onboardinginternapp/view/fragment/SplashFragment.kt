package com.example.onboardinginternapp.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.UserManager
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onboardinginternapp.R
import com.example.onboardinginternapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var fragmentSplashBinding: FragmentSplashBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSplashBinding.bind(view)
        fragmentSplashBinding = binding

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment3_to_homeFragment)
        }, 4000)
    }

}