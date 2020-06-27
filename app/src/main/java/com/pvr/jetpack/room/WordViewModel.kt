package com.pvr.jetpack.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mWordRepository by  lazy {
        WordRepository(application)
    }

    val allWords= mWordRepository.allWords

    fun insert(word: Word) {
        mWordRepository.insert(word)
    }

    fun update(word: Word) {
        mWordRepository.update(word)
    }

    fun delete(word: Word) {
        mWordRepository.delete(word)
    }

    fun clear() {
        mWordRepository.clear()
    }

}