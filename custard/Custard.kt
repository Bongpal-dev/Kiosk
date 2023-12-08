package custard

import Menu

open class Custard: Menu() {
    override val name = "Custard"
    override val price = 0.0

    override fun descriptionMenu() {
        println("메뉴 설명")
    }
}