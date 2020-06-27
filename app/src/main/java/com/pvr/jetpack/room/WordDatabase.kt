package com.pvr.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Word::class], version = 2, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: WordDatabase? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_db"
                )
                    .allowMainThreadQueries()
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)
                    .build()
                    .also {
                        instance = it
                    }
            }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE WORD ADD COLUMN foo_data INTEGER NOT NULL DEFAULT 1")
            }
        }
    }

    abstract fun getWordDao(): WordDao


}