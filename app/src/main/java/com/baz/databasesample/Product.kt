package com.baz.databasesample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "catalog_product", ignoredColumns = ["weight"], indices = [Index(value= ["sku", "name"], unique = true)])
data class Product(
    @PrimaryKey(autoGenerate = true)
    val productId : Int,
    val name: String,
    val sku: String,
    val price: Double,
    val weight: Double,
    @ColumnInfo(name= "quantity_in_stock")
    val quantityInStock: Int
)