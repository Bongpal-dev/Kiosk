package chicken

class HotChicken: Chicken() {
    val name = "HotChicken"
    val price = 9.5
    override fun descriptionMenu() {
        println("1. Hot Chicken    | W 9.5 | 치킨 통살과 스파이시 슬로, 핫 스파이시 시즈닝이 토핑된 치킨 버거")
    }
}