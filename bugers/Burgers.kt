package bugers

import Menu

//interface Bugers {
//    val name: String
//    val price: Double
//    fun descriptionMenu()
//}

open class Burgers(): Menu() {

    override val name = "Burger"
    override val price = 0.0

    override fun descriptionMenu() {
        println("메뉴 설명")
    }


}