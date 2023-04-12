package com.baz.databasesample

import kotlinx.coroutines.flow.first

class ProductRepository(private val productDao: ProductoDao) {
    suspend fun getAllProducts(): List<Product> {
        return productDao.findAllProducts().first()
    }
}