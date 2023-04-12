package com.baz.databasesample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "products", indices = [Index(value = ["sku", "name"], unique = true)] )
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val sku: String,
    val price: Double,
    @ColumnInfo(name = "quantity_in_stock")
    val quantityInStock: Int
)