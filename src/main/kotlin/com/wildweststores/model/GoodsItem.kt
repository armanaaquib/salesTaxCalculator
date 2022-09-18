package com.wildweststores.model

data class GoodsItem(
    val description: String,
    val price: Double,
    val type: ItemType,
    val imported: Boolean = false,
    val quantity: Int = 1
)
