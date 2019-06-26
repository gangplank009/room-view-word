package com.android.gangplank.roomwithview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val dao = WordRoomDb.getInstance(application).wordDao()
        repository = WordRepository(dao)
        allWords = repository.allWords
    }

    fun insertOne(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertOne(word)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}