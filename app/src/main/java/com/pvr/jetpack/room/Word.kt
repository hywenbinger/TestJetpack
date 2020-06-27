package com.pvr.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(
    @ColumnInfo(name = "english_word") var word: String = "",
    @ColumnInfo(name = "chinese_mean") var mean: String = "",
    @ColumnInfo(name = "foo_data") var foo: Boolean = true
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    fun show(): String {
        return "$id----$word----$mean----$foo"
    }
}