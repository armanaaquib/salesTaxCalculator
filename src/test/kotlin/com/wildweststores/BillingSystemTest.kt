package com.wildweststores

import com.wildweststores.model.Bill
import com.wildweststores.model.GoodsItem
import com.wildweststores.model.ItemType
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BillingSystemTest {

    @Test
    fun `should generate bill`() {
        val importedPerfumeBottle = GoodsItem(
            description = "bottle of perfume",
            price = 27.99,
            type = ItemType.OTHER,
            imported = true
        )
        val perfumeBottle =
            GoodsItem(description = "bottle of perfume", price = 18.99, type = ItemType.OTHER)
        val headachePills =
            GoodsItem(description = "packet of headache pills", price = 9.75, type = ItemType.MEDICAL)
        val chocolatesBox = GoodsItem(
            description = "box of chocolates",
            price = 11.25,
            type = ItemType.FOOD,
            imported = true
        )
        val goodsItems = listOf(
            importedPerfumeBottle,
            perfumeBottle,
            headachePills,
            chocolatesBox
        )
        val billingSystem = BillingSystem(goodsItems)

        val actualBill = billingSystem.generateBill()

        val expectedBill = Bill(
            itemPrices = mapOf(
                importedPerfumeBottle to 32.19,
                perfumeBottle to 20.89,
                headachePills to 9.75,
                chocolatesBox to 11.85
            ),
            salesTaxes = 6.70,
            total = 74.68
        )
        assertEquals(expectedBill, actualBill)
    }

}
