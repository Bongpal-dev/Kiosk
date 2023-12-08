class Custard : Menu(){
    //커스터드 앞에 있는 숫자를 받는 변수
    var custard = 0


    //커스터드 종류을 나열한 후 순서대로 가격을 나열
    var custardorder = arrayOf("Classic Hand-Spun Shakes", "Floats", "Cup & Cones", "6500", "6500", "5400")


    //커스터드 메뉴를 출력하고 선택받음과 동시에 총 주문내역과 가격을 출력하는 함수
    fun CusMenu(){
        println("""1. Classic Hand-Spun Shakes  | W 6.5 | 쫀득하고 진한 커스터드가 들어간 클래식 쉐이크
2. Floats                    | W 6.5 | 바닐라 커스터드와 탄산이 만나 탄생한 색다른 음료
3. Cup & Cones               | W 5.4 | 매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림
0. 뒤로가기                  | 뒤로가기""")


        //custard에 입력받은 값 예외처리
        while (true){
            try{
                custard = readLine()!!.toInt()
                if(custard !in 0..3){
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
        if ( custard == 0){
            return menu()
        }


        //커스터드를 선택했을 때 주문내역에 추가할지 묻고 추가하면 가격과 커스터드이름을 출력하고 추가하지 않으면 처음으로 돌아감 + 특정값 이외 예외처리
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
                        OrderList.orderlist = OrderList.orderlist.plus(custardorder[custard - 1])
                        println("주문내역")
                        println(OrderList.orderlist.contentToString())
                        Price.price += custardorder[custard + 2].toInt()
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