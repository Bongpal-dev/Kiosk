package drinks

import Menu

open class Drinks: Menu() {

    override val name = "Drinks"
    override val price: Double = 0.0

    override fun descriptionMenu() {
        println("메뉴 설명")
    }
}