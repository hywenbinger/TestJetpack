package com.pvr.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pvr.jetpack.R
import com.pvr.jetpack.Utils

class LifecycleActivity : AppCompatActivity() {

    private val mObserver by lazy {
        Java7Observer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Utils.logI("LifecycleActivity.onCreate")
        lifecycle.addObserver(mObserver)
    }

    override fun onStart() {
        super.onStart()
        Utils.logI("LifecycleActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Utils.logI("LifecycleActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Utils.logI("LifecycleActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Utils.logI("LifecycleActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Utils.logI("LifecycleActivity.onDestroy")
        lifecycle.removeObserver(mObserver)
    }

}