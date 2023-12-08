class Custard : Menu(){
    var custard = 0
    private var custardorder = arrayOf("Classic Hand-Spun Shakes", "Floats", "Cup & Cones", "6500", "6500", "5400")

    fun CusMenu(){
        println("""1. Classic Hand-Spun Shakes  | W 6.5 | 쫀득하고 진한 커스터드가 들어간 클래식 쉐이크
2. Floats                    | W 6.5 | 바닐라 커스터드와 탄산이 만나 탄생한 색다른 음료
3. Cup & Cones               | W 5.4 | 매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림
0. 뒤로가기                  | 뒤로가기""")

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
        if ( custard == 0){
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
                        orderlist = orderlist.plus(custardorder[custard - 1])
                        println("주문내역")
                        println(orderlist.contentToString())
                        pay += custardorder[custard + 2].toInt()
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