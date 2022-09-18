package com.wildweststores.cli

import com.wildweststores.model.GoodsItem
import com.wildweststores.model.ItemType
import kotlin.test.Test
import kotlin.test.assertEquals

class InputParserTest {

    @Test
    fun `parse input to goods items`() {
        val input = listOf(
            "1 imported bottle of perfume at 27.99",
            "1 bottle of perfume at 18.99",
            "1 packet of headache pills at 9.75",
            "1 box of imported chocolates at 11.25"
        )
        val inputParser = InputParser(input)

        val actualGoodsItems = inputParser.parse()

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
        val expectedGoodsItems = listOf(
            importedPerfumeBottle,
            perfumeBottle,
            headachePills,
            chocolatesBox
        )
        assertEquals(expectedGoodsItems, actualGoodsItems)
    }

}