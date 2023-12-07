package bugers

class ShackStack: Burgers() {

    override val name: String = "ShackStack"
    override val price: Double = 14.8

    override fun descriptionMenu() {
        println("Shack Stack   | W 14.8 | 포토벨로 버섯 패티, 비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거")
    }
}