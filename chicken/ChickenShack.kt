package chicken

class ChickenShack: Chicken() {

    val name = "Chicken Shack"
    val price = 8.0
    override fun descriptionMenu() {
        println("2. Chicken Shack  | W 8.0 | 치킨 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨 버거")
    }
}