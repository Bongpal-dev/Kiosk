package custard

class CupCones: Custard() {

    override val name = "Cup & Cones"
    override val price = 5.4

    override fun descriptionMenu() {
        println("3. Cup & Cones               | W 5.4 | 매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이")
    }
}