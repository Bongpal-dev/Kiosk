class Drinks : Menu(){
    //음료 앞에 있는 번호를 받는 변수
    var drinks = 0

    //음료 종류을 나열한 후 순서대로 가격을 나열
    var drinksorder = arrayOf("Lemonade", "Fresh Brewed Iced Tea", "Fifty/Fifty", "Fountain Soda", "Abita Root Beer", "Hot Tea", "4300", "3500", "3800", "2900", "4800", "3400")


    //음료 메뉴를 출력하고 선택받음과 동시에 총 주문내역과 가격을 출력하는 함수
    fun DrkMenu(){
        println("""1. Lemonade               | W 4.3 | 매장에서 직접 만드는 상큼한 레몬에이드
2. Fresh Brewed Iced Tea  | W 3.5 | 직접 유기농 홍차를 우려낸 아이스 티
3. Fifty/Fifty            | W 3.8 | 레몬에이드와 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료
4. Fountain Soda          | W 2.9 | 코카콜라, 코카콜라 제로, 스프라이트, 환타
5. Abita Root Beer        | W 4.8 | 청량감 있는 독특한 미국식 무알콜 탄산음료
6. Hot Tea                | W 3.4 | 보성 유기농 녹차, 홍차, 페퍼민트 & 레몬그라스
0. 뒤로가기               | 뒤로가기""")


        //drinks에 입력받은 값 예외처리
        while (true){
            try{
                drinks = readLine()!!.toInt()
                if(drinks !in 0..6){
                    println("다시 입력해주세요")
                    continue
                }
                else{
                    break
                }
            }
            catch(e:Exception){
                println("다시 입력하세요")
            }
        }


        //뒤로가기를 눌렀을 때 실행
        if ( drinks == 0){
            return menu()
        }


        //음료를 선택했을 때 주문내역에 추가할지 묻고 추가하면 가격과 움료이름을 출력하고 추가하지 않으면 처음으로 돌아감 + 특정값 이외 예외처리
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
                        orderlist = orderlist.plus(drinksorder[drinks - 1])
                        println("주문내역")
                        println(orderlist.contentToString())
                        pay += drinksorder[drinks + 5].toInt()
                        println("총 가격 ${pay}")
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