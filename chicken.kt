class Chicken : Menu() {
    var chicken = 0
    var chickenorder = arrayOf("Hot Chicken", "Chicken Shack", "Chick'n Bites", "9500", "8000", "5900")


    fun ChicMenu() {
        println(
            """1. Hot Chicken    | W 9.5 | 치킨 통살과 스파이시 슬로, 핫 스파이시 시즈닝이 토핑된 치킨 버거
2. Chicken Shack  | W 8.0 | 치킨 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨 버거
3. Chick'n Bites  | W 5.9 | 한 입에 먹기 좋은 바삭한 치킨 바이트 (6-count)
0. 뒤로가기       | 뒤로가기"""
        )
        while (true) {
            try {
                chicken = readLine()!!.toInt()
                if (chicken !in 0..3) {
                    println("다시 입력해주세요")
                    continue
                } else {
                    break
                }
            } catch (e: Exception) {
                println("다시 입력하세요")
            }
        }
        if (chicken == 0) {
            return menu()
        } else {
            println(
                """주문내역에 추가하시겠습니까?
네[1], 아니요[2]
            """.trimMargin()
            )
            while (true) {
                try {
                    check = readLine()!!.toInt()
                    if (check == 1) {
                        orderlist = orderlist.plus(chickenorder[chicken - 1])
                        println("주문내역")
                        println(orderlist.contentToString())
                        pay += chickenorder[chicken + 2].toInt()
                        println("총 가격 ${pay}")
                        break
                    } else {
                        println("정확하게 입력해주세요")
                    }
                } catch (e: Exception) {
                    println("정확하게 입력해주세요")
                }
            }
        }
    }
}