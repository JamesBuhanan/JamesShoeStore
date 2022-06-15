package com.example.jamesshoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData()
    val companyName: MutableLiveData<String> = MutableLiveData()
    val size: MutableLiveData<String> = MutableLiveData()
    val description: MutableLiveData<String> = MutableLiveData()
}