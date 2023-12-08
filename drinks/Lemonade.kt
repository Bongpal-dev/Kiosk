package drinks

class Lemonade: Drinks() {

    override val name: String = "Lemonade"
    override val price: Double = 4.3

    override fun descriptionMenu() {
        println("1. Lemonade               | W 4.3 | 매장에서 직접 만드는 상큼한 레몬에이드")
    }
}