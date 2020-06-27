package com.pvr.jetpack.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BindingViewModel : ViewModel() {

    val mNumber: MutableLiveData<Int> = MutableLiveData<Int>()

    fun setNumber() {
        mNumber.value = 100
    }

}