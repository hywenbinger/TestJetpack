package com.pvr.jetpack.room

import android.content.Context

class WordRepository(private var mContext: Context) {

    private val mWordDatabase by lazy {
        WordDatabase.getInstance(mContext)
    }
    private val mWordDao by lazy {
        mWordDatabase.getWordDao()
    }

    val allWords = mWordDao.getAll()

    fun insert(word: Word) {
        mWordDao.insertWord(word)
    }

    fun update(word: Word) {
        mWordDao.updateWord(word)
    }

    fun delete(word: Word) {
        mWordDao.deleteWord(word)
    }

    fun clear() {
        mWordDao.clear()
    }


}