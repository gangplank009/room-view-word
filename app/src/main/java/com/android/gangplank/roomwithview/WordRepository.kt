package com.android.gangplank.roomwithview

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAll()

    @WorkerThread
    suspend fun insertOne(word: Word) {
        wordDao.insertOne(word)
    }

    @WorkerThread
    suspend fun deleteAll() {
        wordDao.deleteAll()
    }
}