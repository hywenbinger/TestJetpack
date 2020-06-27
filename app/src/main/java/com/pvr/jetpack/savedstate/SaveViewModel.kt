package com.pvr.jetpack.savedstate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveViewModel(private val mHandle: SavedStateHandle) : ViewModel() {

    val mUserName: MutableLiveData<String> by lazy {
        mHandle.getLiveData("data_key", "unknown")
    }

    fun setName() {
        mUserName.value = "wayne"
    }

}