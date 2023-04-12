package com.baz.databasesample

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface WordDao {

    @Query("SELECT * FROM world_table ORDER BY word ASC")
    fun getAlphabetizeWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM world_table")
    suspend fun deleteAll()

}