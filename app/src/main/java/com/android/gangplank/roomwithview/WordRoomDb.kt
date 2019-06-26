package com.android.gangplank.roomwithview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDb: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDb? = null

        fun getInstance(context: Context): WordRoomDb {
            return INSTANCE ?: synchronized(this) {
                val instance = createDb(context)
                INSTANCE = instance
                return instance
            }
        }

        private fun createDb(context: Context) =
            Room.databaseBuilder(context.applicationContext, WordRoomDb::class.java, "words_db")
                .build()
    }
}