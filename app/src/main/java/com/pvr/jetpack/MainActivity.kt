package com.pvr.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pvr.jetpack.databinding.DataBindingActivity
import com.pvr.jetpack.lifecycle.LifecycleActivity
import com.pvr.jetpack.livedata.LiveDataActivity
import com.pvr.jetpack.room.RoomActivity
import com.pvr.jetpack.savedstate.SavedStateActivity
import com.pvr.jetpack.viewmodel.ViewModelActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLifecycleClick(view: View) {
        startActivity(Intent(this, LifecycleActivity::class.java))
    }

    fun onSaveStateClick(view: View) {
        startActivity(Intent(this, SavedStateActivity::class.java))
    }

    fun onViewModelClick(view: View) {
        startActivity(Intent(this, ViewModelActivity::class.java))
    }

    fun onLiveDataClick(view: View) {
        startActivity(Intent(this, LiveDataActivity::class.java))
    }

    fun onDataBindingClick(view: View) {
        startActivity(Intent(this, DataBindingActivity::class.java))
    }

    fun onRoomClick(view: View) {
        startActivity(Intent(this, RoomActivity::class.java))
    }

}