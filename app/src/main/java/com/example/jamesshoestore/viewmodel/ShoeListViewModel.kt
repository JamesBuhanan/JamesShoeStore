package com.example.jamesshoestore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jamesshoestore.model.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoes: MutableList<Shoe> = mutableListOf()
    val shoes: LiveData<MutableList<Shoe>>
        get() = MutableLiveData(_shoes)

    fun addShoe(shoe: Shoe) {
        _shoes.add(shoe)
    }

    init {
        Log.i("ShoeListViewModel", "ShoeListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel", "ShoeListViewModel destroyed!")
    }
}