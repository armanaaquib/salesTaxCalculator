package com.wildweststores.model

data class Bill(
    val itemPrices: Map<GoodsItem, Double>,
    val salesTaxes: Double,
    val total: Double
)
