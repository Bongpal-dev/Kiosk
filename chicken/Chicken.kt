package chicken

import Menu

open class Chicken(): Menu() {

    override val name = "Chicken"
    override val price = 0.0

    override fun descriptionMenu() {
        println("메뉴 설명")
    }
}