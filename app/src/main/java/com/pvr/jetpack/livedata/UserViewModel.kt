package com.pvr.jetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val mUserName: MutableLiveData<String> = MutableLiveData<String>()

}