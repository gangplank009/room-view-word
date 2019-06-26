package com.android.gangplank.roomwithview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAll(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}