package com.example.jamesshoestore.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.R
import com.example.jamesshoestore.databinding.FragmentShoeListBinding
import com.example.jamesshoestore.viewmodel.ShoeListViewModel

class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false,
        )
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionFourthFragmentToFifthFragment())
        }

        viewModel.shoes.observe(this, Observer {
            binding.shoeList.removeAllViews()
            it.forEach {
                val textView = TextView(context)
                textView.text = it.name
                textView.textSize = 34f
                binding.shoeList.addView(textView)
            }
        })
    }
}