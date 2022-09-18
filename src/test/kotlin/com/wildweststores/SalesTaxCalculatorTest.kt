package com.wildweststores

import com.wildweststores.model.GoodsItem
import com.wildweststores.model.ItemType
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SalesTaxCalculatorTest {

    @Test
    fun `calculate basic tax of tax excepted goods item`() {
        val goodsItem =
            GoodsItem(description = "book", price =12.49, type = ItemType.BOOK)
        val salesTaxCalculator = SalesTaxCalculator(goodsItem)

        val actualTax = salesTaxCalculator.basicTax()

        val expectedTax = 0.0
        assertEquals(expectedTax, actualTax)
    }

    @Test
    fun `calculate basic tax of other tan tax excepted goods item`() {
        val goodsItem =
            GoodsItem(description = "music CD", price =14.99, type = ItemType.OTHER)
        val salesTaxCalculator = SalesTaxCalculator(goodsItem)

        val actualTax = salesTaxCalculator.basicTax()

        val expectedTax = 1.5
        assertEquals(expectedTax, actualTax)
    }

    @Test
    fun `calculate import duty of imported goods item`() {
        val goodsItem =
            GoodsItem(
                description = "bottle of perfume",
                price =47.50,
                type = ItemType.OTHER,
                imported = true
            )
        val salesTaxCalculator = SalesTaxCalculator(goodsItem)

        val actualImportDuty = salesTaxCalculator.importDuty()

        val expectedImportDuty = 2.4
        assertEquals(expectedImportDuty, actualImportDuty, .001)
    }

    @Test
    fun `calculate import duty of not imported goods item`() {
        val goodsItem =
            GoodsItem(description = "music CD", price =14.99, type = ItemType.OTHER, imported = false)
        val salesTaxCalculator = SalesTaxCalculator(goodsItem)

        val actualImportDuty = salesTaxCalculator.importDuty()

        val expectedImportDuty = 0.0
        assertEquals(expectedImportDuty, actualImportDuty)
    }

}
