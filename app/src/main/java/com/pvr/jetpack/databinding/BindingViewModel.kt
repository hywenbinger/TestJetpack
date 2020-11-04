package com.pvr.jetpack.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BindingViewModel : ViewModel() {

    val mNumber: MutableLiveData<Int> = MutableLiveData<Int>(200)

    fun setNumber() {
        mNumber.value = 100

//        mListLiveData.value.add("")
//        mList.value.add("")

        mStringList.add("")
    }

    val mListLiveData by lazy {
        MutableLiveData<MutableList<String>>().also { it.value = mutableListOf() }
    }

    val mList = MutableLiveData<MutableList<String>>(mutableListOf<String>())

    val mStringList = mutableListOf<String>()

}