package com.baz.databasesample

import java.util.concurrent.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords = wordDao.getAlphabetizeWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}