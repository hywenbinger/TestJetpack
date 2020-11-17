package com.pvr.jetpack.databinding

import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {

    val mStudent = MutableLiveData(Student("wayne", ObservableInt(18)))

    fun setStudent() {
        val age = (1..100).random()
        mStudent.value?.age?.set(age)
    }

}