package concretes

class ShackAttack: Concretes() {
    override val name = "Shack Attack"
    override val price: Double = 6.2

    override fun descriptionMenu() {
        println("1. Shack Attack         | W 6.2 | 초콜릿 커스터드에 퍼지 소스와 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트")
    }
}