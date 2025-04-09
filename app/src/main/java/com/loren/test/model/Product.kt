package com.loren.test.model

data class Product(
    val name: String,
    val description: String,
    val imageUrl: String? = null,
    val isHot: Boolean = false,
    val isNew: Boolean = false,
    val platform: String
)

data class ProductCategory(
    val title: String,
    val products: List<Product>
) 