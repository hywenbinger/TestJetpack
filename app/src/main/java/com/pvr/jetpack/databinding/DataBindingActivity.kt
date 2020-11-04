package com.pvr.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils
import com.pvr.jetpack.livedata.UserViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

/**
 * https://www.jianshu.com/p/bd9016418af2 -- Android DataBinding 从入门到进阶
 */
class DataBindingActivity : AppCompatActivity() {

    private val mViewModel by lazy {
        ViewModelProvider(this)[BindingViewModel::class.java]
    }
    private lateinit var mBinding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        mBinding.data = mViewModel
        mBinding.lifecycleOwner = this
        mViewModel.mNumber.observe(this, Observer {
            Utils.logI("getNumber, $it")
        })

    }

}