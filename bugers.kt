class Bugers : Menu() {
    //버거 앞에 있는 숫자 입력받는 변수
    var bugers = 0


    //버거 종류을 나열한 후 순서대로 가격을 나열
    var bugerorder = arrayOf("ShackBurger", "SmokeShack", "Shroom Burger", "Shack Stack", "Hamburger", "8400", "10600", "10000", "14800", "6800")


    //콘크리트 메뉴를 출력하고 선택받음과 동시에 총 주문내역과 가격을 출력하는 함수
    fun BugMenu() {
        println(
            """1. ShackBurger   | W 8.4 | 비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 10.6 | 베이컨, 체리 페퍼, 비프 패티와 쉑소스가 토핑된 치즈버거
3. Shroom Burger | W 10.0 | 포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리안 버거
4. Shack Stack   | W 14.8 | 포토벨로 버섯 패티, 비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거
5. Hamburger     | W 6.8 | 포테이토 번과 비프 패티를 기본으로 토핑을 취향에 따라 선택할 수 있는 버거
0. 뒤로가기      | 뒤로가기
        """.trimIndent()
        )


        //주문받는 코드(예외처리함)
        while (true) {
            try {
                bugers = readln()!!.toInt()
                if (bugers !in 0..5) {
                    println("다시 입력해주세요")
                    continue
                } else {
                    break
                }
            } catch (e: Exception) {
                println("다시 입력하세요")
            }
        }


        //돌아가기를 눌렀을 때 메인으로 돌아가고 주문을 했을 경우 주문내역에 추가하고 주문내역을 보여주는 코드
        if (bugers == 0) {
            return menu()
        }
        else {
            println(
                """주문내역에 추가하시겠습니까?
네[1], 아니요[2]
            """.trimMargin()
            )
            while (true) {
                try {
                    check = readLine()!!.toInt()
                    if (check == 1) {
                        OrderList.orderlist = OrderList.orderlist.plus(bugerorder[bugers - 1])
                        println("주문내역")
                        println(OrderList.orderlist.contentToString())
                        Price.price += bugerorder[bugers + 4].toInt()
                        println("총 가격 ${Price.price}")
                        break
                    } else if (check == 2) {
                        println("다시 선택해주세요")
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