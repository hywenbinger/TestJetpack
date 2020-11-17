package com.pvr.jetpack.databinding

import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pvr.jetpack.Utils

class ProgressViewModel : ViewModel() {

    val mProgress = MutableLiveData(Progress(5, 1))

    fun getProgress() {
        Utils.logI("getProgress, ${mProgress.value}")
    }

}