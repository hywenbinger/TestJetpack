package com.pvr.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils

/**
 * https://www.jianshu.com/p/bd9016418af2 -- Android DataBinding 从入门到进阶
 */
class DataBindingActivity : AppCompatActivity() {

    private val mNumberViewModel by lazy {
        ViewModelProvider(this)[NumberViewModel::class.java]
    }

    private val mStudentViewModel by lazy {
        ViewModelProvider(this).get(StudentViewModel::class.java)
    }

    private val mProgressViewModel by lazy {
        ViewModelProvider(this).get(ProgressViewModel::class.java)
    }

    private lateinit var mBinding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        mBinding.lifecycleOwner = this

        mBinding.numberViewModel = mNumberViewModel
        mNumberViewModel.mNumber.observe(this, Observer {
            Utils.logI("getNumber, $it")
        })

        /**
         * BaseObservable、ObservableField、......
         */
        mBinding.studentViewModel = mStudentViewModel
        mStudentViewModel.mStudent.observe(this, Observer {
            Utils.logI("getStudent, $it")
        })
        mStudentViewModel.mStudent.value?.age?.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Utils.logI("getStudent, $propertyId, ${(sender as? ObservableInt)?.get()}")
            }

        })

        /**
         * 双向绑定
         */
        mBinding.progressViewModel = mProgressViewModel
        mProgressViewModel.mProgress.observe(this, Observer {
            Utils.logI("getProgress, $it")
        })

    }

}