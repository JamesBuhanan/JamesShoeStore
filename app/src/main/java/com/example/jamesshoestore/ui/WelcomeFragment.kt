package com.example.jamesshoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.R
import com.example.jamesshoestore.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false,
        )
        binding.welcomeFragment = this


        return binding.root
    }

    fun buttonClicked() {
        findNavController().navigate(WelcomeFragmentDirections.actionSecondFragmentToThirdFragment())
    }
}