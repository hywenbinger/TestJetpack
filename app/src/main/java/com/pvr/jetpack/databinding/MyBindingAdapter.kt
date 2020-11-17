package com.pvr.jetpack.databinding

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object MyBindingAdapter {

    @BindingAdapter("setIV")
    @JvmStatic
    fun loadImage(view: ImageView, color: Int) {
        view.setImageResource(color)
    }

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: Button, text: String) {
        view.text = "$text--btn"
    }

}