package bugers

class SmokeShack: Burgers() {

    override val name: String = "SomkeShack"
    override val price: Double = 10.6

    override fun descriptionMenu() {
        println("SmokeShack    | W 10.6 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거")
    }
}

