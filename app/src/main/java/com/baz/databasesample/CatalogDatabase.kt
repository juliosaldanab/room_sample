package com.baz.databasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Product::class])
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun productDao(): ProductoDao
    companion object {

        const val DB_NAME = "catalog"
        @Volatile
        var INSTANCE: CatalogDatabase? = null

        fun getDatabase(context: Context): CatalogDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatalogDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}