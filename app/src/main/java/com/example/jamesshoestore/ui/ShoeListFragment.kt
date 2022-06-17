package com.example.jamesshoestore.ui

import android.os.Bundle
import android.view.*
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
        binding.shoeListFragment = this

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val thing = requireView().findNavController()
//        val thing2 = NavigationUI.onNavDestinationSelected(item, thing)
        when (item.itemId) {
            R.id.some_id -> findNavController().navigate(ShoeListFragmentDirections.actionFourthFragmentToFirstFragment())
        }
        return true
    }

    //    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    fun fabClicked() {
        findNavController().navigate(ShoeListFragmentDirections.actionFourthFragmentToFifthFragment())
    }
}