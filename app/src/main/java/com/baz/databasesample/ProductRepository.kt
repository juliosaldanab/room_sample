package com.baz.databasesample

import kotlinx.coroutines.flow.Flow

class ProductRepository(private val productDao: ProductDao) {

    suspend fun addProduct(product: Product){
        productDao.insert(product)
    }

    fun getProducts(): Flow<List<Product>> {
        return productDao.getAllProducts()
    }
}