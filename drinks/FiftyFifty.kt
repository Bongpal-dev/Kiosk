package drinks

class FiftyFifty: Drinks() {

    override val name: String = "Fifty/Fifty"
    override val price: Double = 3.8

    override fun descriptionMenu() {
        println("3. Fifty/Fifty            | W 3.8 | 레몬에이드와 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료")
    }
}