package com.baz.databasesample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(product: Product)
    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM products")
    fun findAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id= :id")
    fun findProductById(id: Int): Flow<Product>

    @Query("SELECT * FROM products WHERE sku LIKE :sku AND name LIKE :name")
    fun findProductBySkuAndName(sku:String, name: String): Flow<Product>
}