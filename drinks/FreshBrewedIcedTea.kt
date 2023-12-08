package drinks

class FreshBrewedIcedTea: Drinks() {

    override val name: String = "Fresh Brewed Iced Tea"
    override val price: Double = 3.5

    override fun descriptionMenu() {
        println("2. Fresh Brewed Iced Tea  | W 3.5 | 직접 유기농 홍차를 우려낸 아이스 티")
    }
}