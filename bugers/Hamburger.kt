package bugers

class Hamburger: Burgers() {

    override val name: String = "Hamburger"
    override val price: Double = 6.8

    override fun descriptionMenu() {
        println("Hamburger     | W 6.8 | 포테이토 번과 비프 패티를 기본으로 토핑을 취향에 따라 선택할 수 있는 버거")
    }
}