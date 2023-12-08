package drinks

class FountainSoda: Drinks() {
    override val name: String = "Fountain Soda"
    override val price: Double = 2.9

    override fun descriptionMenu() {
        println("4. Fountain Soda          | W 2.9 | 코카콜라, 코카콜라 제로, 스프라이트, 환타")
    }
}