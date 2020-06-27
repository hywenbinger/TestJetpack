package com.pvr.jetpack.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao //database access object
interface WordDao {
    @Insert
    fun insertWord(word: Word)

    @Update
    fun updateWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Query("DELETE FROM WORD")
    fun clear()

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    fun getAll(): LiveData<MutableList<Word>>

}