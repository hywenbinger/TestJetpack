package com.pvr.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    //    val mUserName: MutableLiveData<String> = MutableLiveData<String>()
    private val mUserName = MutableLiveData<String>("")

    val userName: LiveData<String>
        get() = mUserName

    fun setUserName(name: String) {
        mUserName.value = name
    }

}