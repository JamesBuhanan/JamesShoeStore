package com.example.jamesshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.databinding.FragmentShoeDetailBinding
import com.example.jamesshoestore.model.Shoe

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
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionFifthFragmentToFourthFragment())
        }
        binding.saveButton.setOnClickListener {
            // Make Shoe from EditTexts
            val shoe = Shoe(
                name = detailViewModel.name.value!!,
                companyName = detailViewModel.companyName.value!!,
                size = detailViewModel.size.value!!.toInt(),
                description = detailViewModel.description.value!!,
            )

            // Add Shoe to viewModel.shoes
            listViewModel.addShoe(shoe)
            findNavController().navigate(ShoeDetailFragmentDirections.actionFifthFragmentToFourthFragment())
        }
    }
}