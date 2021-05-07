package com.example.timecalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimeViewModel : ViewModel() {
    var hourInput = MutableLiveData<Int>()
    var minInput = MutableLiveData<Int>()
    var secInput = MutableLiveData<Int>()


}