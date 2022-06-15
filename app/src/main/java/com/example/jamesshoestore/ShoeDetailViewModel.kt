package com.example.jamesshoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
     val name: MutableLiveData<String> = MutableLiveData()
//    val name: LiveData<String>
//        get() = name
     val companyName: MutableLiveData<String> = MutableLiveData()
//    val companyName: LiveData<String>
//        get() = companyName
     val size: MutableLiveData<String> = MutableLiveData()
//    val size: LiveData<String>
//        get() = size
     val description: MutableLiveData<String> = MutableLiveData()
//    val description: LiveData<String>
//        get() = _description
}