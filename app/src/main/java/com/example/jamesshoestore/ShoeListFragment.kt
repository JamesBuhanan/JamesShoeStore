package com.example.jamesshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jamesshoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.count++
        Timber.e("HERE LIST: ${viewModel.count}")

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionFourthFragmentToFifthFragment())
        }
    }
    //possibly get something that imports Shoe mutable list to the scroll view linear layout?
    override fun onResume() {
        super.onResume()
        binding.shoeList.removeAllViews()
        viewModel.shoes.forEach{
            val textView = TextView(context)
            textView.text = it.name
            binding.shoeList.addView(textView)
        }

    }
}