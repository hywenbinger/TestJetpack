package com.pvr.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.pvr.jetpack.R
import com.pvr.jetpack.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    private val mViewModel by lazy {
        ViewModelProvider(this)[WordViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        mViewModel.allWords.observe(this, Observer {
            mTV.text = ""
            for (word in it) {
                mTV.append("${word.show()}\n")
            }
        })
    }

    fun onInsertClick(view: View) {
        val word = Word("hello", "你好")
        mViewModel.insert(word)
    }

    fun onUpdateClick(view: View) {
        val word = Word("world", "世界", false)
        word.id = mET.text.toString().toInt()
        mViewModel.update(word)
    }

    fun onDeleteClick(view: View) {
        val word = Word()
        word.id = mET.text.toString().toInt()
        mViewModel.delete(word)
    }

    fun onClearClick(view: View) {
        mViewModel.clear()
    }

}