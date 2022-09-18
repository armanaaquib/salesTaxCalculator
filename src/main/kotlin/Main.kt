import com.wildweststores.BillingSystem
import com.wildweststores.cli.InputParser
import com.wildweststores.cli.Printer

fun main() {
    val input = listOf(
        "1 imported bottle of perfume at 27.99",
        "1 bottle of perfume at 18.99",
        "1 packet of headache pills at 9.75",
        "1 box of imported chocolates at 11.25"
    )

    val inputParser = InputParser(input)
    val goodsItems = inputParser.parse()

    val billingSystem = BillingSystem(goodsItems)

    val printer = Printer(billingSystem.generateBill())
    printer.displayBill()
}
