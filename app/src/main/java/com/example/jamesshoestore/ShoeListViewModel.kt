package com.example.jamesshoestore

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.jamesshoestore.model.Shoe

class ShoeListViewModel : ViewModel() {
    var count: Int = 0
    //private val saveButton = MutableLiveData<Shoe>()
    val shoes = mutableListOf<Shoe>(

    )
    init {
        Log.i("ShoeListViewModel","ShoeListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel", "ShoeListViewModel destroyed!")
    }
}