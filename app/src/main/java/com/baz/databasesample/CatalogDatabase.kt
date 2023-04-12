package com.baz.databasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Product::class])
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {

        private const val DB_NAME = "catalog_database"

        private var INSTANCE: CatalogDatabase? = null


        fun getDatabase(context: Context): CatalogDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatalogDatabase::class.java,
                    "catalog_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}