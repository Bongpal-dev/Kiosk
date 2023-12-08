package concretes

import Menu

open class Concretes: Menu() {

    override val name = "Concretes"
    override val price = 0.0

    override fun descriptionMenu() {
        println("메뉴 설명")
    }
}