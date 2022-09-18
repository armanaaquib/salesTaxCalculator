package com.wildweststores

import com.wildweststores.model.GoodsItem
import com.wildweststores.model.ItemType
import com.wildweststores.util.roundUpTo

class SalesTaxCalculator(private val goodsItem: GoodsItem) {

    companion object {
        private const val ROUNDUP_FACTOR = 0.05
        private const val BASIC_TAX_PERCENTAGE = 10.0
        private const val IMPORT_DUTY_PERCENTAGE = 5.0
    }

    fun basicTax(): Double {
        return if (goodsItem.type == ItemType.OTHER)
            (goodsItem.price * BASIC_TAX_PERCENTAGE / 100).roundUpTo(ROUNDUP_FACTOR)
        else 0.0
    }

    fun importDuty(): Double {
        return if (goodsItem.imported)
            (goodsItem.price * IMPORT_DUTY_PERCENTAGE / 100).roundUpTo(ROUNDUP_FACTOR)
        else 0.0
    }

}
