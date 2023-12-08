package chicken

class ChickenBites: Chicken() {

    override val name = "Chick'n Bites"
    override val price = 5.9
    override fun descriptionMenu() {
        println("3. Chick'n Bites  | W 5.9 | 한 입에 먹기 좋은 바삭한 치킨 바이트 (6-count)")
    }
}