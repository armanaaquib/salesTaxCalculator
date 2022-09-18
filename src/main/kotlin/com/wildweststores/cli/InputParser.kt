package com.wildweststores.cli

import com.wildweststores.model.GoodsItem
import com.wildweststores.model.ItemType

class InputParser(private val input: List<String>) {

    fun parse() = input.map {
        var stringList = it.split(" at ")

        val price = stringList[1].toDouble()

        stringList = stringList[0].split(" ")

        val quantity = stringList[0].toInt()
        val imported = stringList.contains("imported")

        val descriptionBuilder = StringBuilder()
        for (i in 1..stringList.lastIndex) {
            if(stringList[i] != "imported") {
                if(descriptionBuilder.isNotEmpty()) descriptionBuilder.append(" ")
                descriptionBuilder.append(stringList[i])
            }
        }
        val description = descriptionBuilder.toString()

        val itemType = findItemType(description)

        GoodsItem(description, price, itemType, imported, quantity)
    }

    private fun findItemType(description: String): ItemType {
        val foodProducts = listOf("chocolates")
        val books = listOf("book")
        val medicalProducts = listOf("pills")

        return when {
            foodProducts.any { description.contains(it) } -> ItemType.FOOD
            books.any { description.contains(it) } -> ItemType.BOOK
            medicalProducts.any { description.contains(it) } -> ItemType.MEDICAL
            else -> ItemType.OTHER
        }
    }
}
