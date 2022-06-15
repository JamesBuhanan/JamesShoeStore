package com.example.jamesshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.databinding.FragmentShoeDetailBinding
import com.example.jamesshoestore.model.Shoe
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //How to use FragmentShoeDetailBinding
        binding = FragmentShoeDetailBinding.inflate(inflater)
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
                name = binding.shoeName.text.toString(),
                companyName = binding.companyName.text.toString(),
                size = binding.shoeNumber.text.toString().toInt(),
                description = binding.shoeDescription.text.toString(),
            )

            // Add Shoe to viewModel.shoes
            viewModel.addShoe(shoe)
            findNavController().navigate(ShoeDetailFragmentDirections.actionFifthFragmentToFourthFragment())
        }
    }
}