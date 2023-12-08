package kiosk
open class MenuItem(val name: String, val price: Int, val info: String) {
    fun displayInfo() {
        println("  $name - ${priceConverter(price)}")
        println("     [${info}]")
    }
}