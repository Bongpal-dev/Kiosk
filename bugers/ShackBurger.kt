package bugers
class ShackBurger: Burgers() {

    override val name: String = "ShackBurger"
    override val price: Double = 8.4

    override fun descriptionMenu() {
        println("ShackBurger   | W 8.4 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거")
    }
}
