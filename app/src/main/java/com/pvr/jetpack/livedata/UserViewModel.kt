package com.pvr.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvr.jetpack.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

//    private val mUserName: MutableLiveData<String> = MutableLiveData<String>()

//    private val mUserName: MutableLiveData<String> by lazy {
//        MutableLiveData<String>().also { it.value = "" }
//    }

    private val mUserName = MutableLiveData<String>("")

    val userName: LiveData<String>
        get() = mUserName

    fun setUserName(name: String) {
        mUserName.value = name
    }

    fun setUserNameCoroutine() {
        viewModelScope.launch {
            Utils.logI("setUserNameCoroutine start, ${Thread.currentThread().name}")
            val userName = withContext(Dispatchers.IO) {
                Utils.logI("getDataDelay start, ${Thread.currentThread().name}")
                delay(3000)
                Utils.logI("getDataDelay end, ${Thread.currentThread().name}")
                return@withContext "wayne"
            }
            Utils.logI("setUserNameCoroutine end, ${Thread.currentThread().name}")
            mUserName.value = userName
        }
    }

}