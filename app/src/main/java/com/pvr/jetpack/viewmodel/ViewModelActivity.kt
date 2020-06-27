package com.pvr.jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    private lateinit var mViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

//        mViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

//        mViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        mViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        Utils.logI("onCreate, ${mViewModel.mUserName}")
        mNameTV.text = mViewModel.mUserName
    }

    fun onBtnClick(view: View) {
        mViewModel.mUserName = "wayne"
        Utils.logI("onBtnClick, ${mViewModel.mUserName}")
        mNameTV.text = mViewModel.mUserName
    }
}