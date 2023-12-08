package drinks

class HotTea: Drinks() {
    override val name: String = "Hot Tea"
    override val price: Double = 3.4

    override fun descriptionMenu() {
        println("6. Hot Tea                | W 3.4 | 보성 유기농 녹차, 홍차, 페퍼민트 & 레몬그라스")
    }
}