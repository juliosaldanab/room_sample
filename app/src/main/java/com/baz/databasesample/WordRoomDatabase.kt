package com.baz.databasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Word::class), version = 1,  exportSchema = false)
abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object{

        const val DB_NAME = "word_database"
        @Volatile
        private var INSTANCE :  WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    DB_NAME

                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}