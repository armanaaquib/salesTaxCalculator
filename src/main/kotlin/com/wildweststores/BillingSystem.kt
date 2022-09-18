package com.wildweststores

import com.wildweststores.model.Bill
import com.wildweststores.model.GoodsItem
import com.wildweststores.util.roundUpTo
import com.wildweststores.util.roundToDecimalPoint

class BillingSystem(private val goodsItems: List<GoodsItem>) {

    companion object {
        private const val ROUNDUP_FACTOR = 0.05
    }

    fun generateBill(): Bill {
        var salesTaxes = 0.0
        var total = 0.0

        val priceItems = goodsItems.associateWith { goodsItem ->
            val salesTaxCalculator = SalesTaxCalculator(goodsItem)

            val tax = salesTaxCalculator.basicTax() + salesTaxCalculator.importDuty()
            val finalPrice = goodsItem.price + tax

            salesTaxes += tax
            total += finalPrice

            finalPrice.roundToDecimalPoint(2)
        }

        return Bill(priceItems, salesTaxes.roundUpTo(ROUNDUP_FACTOR), total.roundToDecimalPoint(2))
    }

}
