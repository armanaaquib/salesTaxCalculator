package com.wildweststores.cli

import com.wildweststores.model.Bill

class Printer(private val bill: Bill) {

    fun displayBill() {
        bill.itemPrices.forEach {
            val goodsItem = it.key
            val finalPrice = it.value

            val importedMessage = if(goodsItem.imported) "imported " else ""
            println("""
                ${goodsItem.quantity} $importedMessage${goodsItem.description}: $finalPrice
            """.trimIndent())
        }

        println("Sales Taxes: ${bill.salesTaxes}")
        println("Total: ${bill.total}")
    }

}