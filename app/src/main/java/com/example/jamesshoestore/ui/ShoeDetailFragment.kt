package com.example.jamesshoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.R
import com.example.jamesshoestore.databinding.FragmentShoeDetailBinding
import com.example.jamesshoestore.model.Shoe
import com.example.jamesshoestore.viewmodel.ShoeDetailViewModel
import com.example.jamesshoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private val listViewModel: ShoeListViewModel by activityViewModels()
    lateinit var detailViewModel: ShoeDetailViewModel
    lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //How to use FragmentShoeDetailBinding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        detailViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this
        binding.shoeDetailFragment = this
        // Inflate the layout for this fragment
        return binding.root
    }

    fun cancelClicked() {
        findNavController().navigate(ShoeDetailFragmentDirections.actionFifthFragmentToFourthFragment())
    }

    fun saveClicked() {
        val shoe = Shoe(
            name = detailViewModel.name.value!!,
            companyName = detailViewModel.companyName.value!!,
            size = detailViewModel.size.value!!.toInt(),
            description = detailViewModel.description.value!!,
        )
        listViewModel.addShoe(shoe)

        findNavController().navigate(ShoeDetailFragmentDirections.actionFifthFragmentToFourthFragment())
    }
}