package bugers

class ShroomBurger: Burgers() {

    override val name: String = "ShroomBurger"
    override val price: Double = 10.0

    override fun descriptionMenu() {
        println("Shroom Burger | W 10.0 | 포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리안 버거")
    }
}