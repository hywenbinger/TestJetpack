package com.pvr.jetpack.livedata

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    private lateinit var mViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        mViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        mViewModel.userName.observe(this,
            Observer<String> { name ->
                mNameTV.text = name
                Utils.logI("getName, ${mViewModel.userName.value}")
            })
    }

    fun onBtnClick(view: View) {
        mViewModel.setUserName("wayne")
        Utils.logI("onBtnClick, ${mViewModel.userName.value}")
    }


}