package com.pvr.jetpack.savedstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistry
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils
import com.pvr.jetpack.livedata.UserViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class SavedStateActivity : AppCompatActivity() {

    private val mViewModel: SaveViewModel by lazy {
        ViewModelProvider(
            this,
            SavedStateViewModelFactory(application, this)
        )[SaveViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_state)

        mViewModel.mUserName.observe(this,
            Observer<String> { name ->
                mNameTV.text = name
                Utils.logI("getName, ${mViewModel.mUserName.value}")
            })
    }

    fun onBtnClick(view: View) {
        mViewModel.setName()
        Utils.logI("onBtnClick, ${mViewModel.mUserName.value}")
    }

}