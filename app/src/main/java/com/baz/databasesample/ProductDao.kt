package com.baz.databasesample

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM catalog_product")
    fun  getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM catalog_product WHERE quantity_in_stock > 0")
    fun productsInStock(): Flow<List<Product>>
}