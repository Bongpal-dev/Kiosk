class Concretes : Menu(){
    //콘크리트 앞에 있는 숫자를 받는 변수
    var concretes = 0

    //콘크리트 종류을 나열한 후 순서대로 가격을 나열
    var concretesorder = arrayOf("Shack Attack", "Honey Butter Crunch", "Better 2Gether", "Shack-ffogato", "Shack in the Garden", "6200", "6200", "6200", "6200", "6200")


    //콘크리트 메뉴를 출력하고 선택받음과 동시에 총 주문내역과 가격을 출력하는 함수
    fun ConMenu() {
        println("""1. Shack Attack         | W 6.2 | 초콜릿 커스터드에 퍼지 소스와 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트
2. Honey Butter Crunch  | W 6.2 | 바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트
3. Better 2Gether       | W 6.2 | 바닐라와 초콜릿을 반씩 넣고 초콜릿 트러플 쿠키 도우와 쇼트브레드를 믹스한 특별한 콘크리트
4. Shack-ffogato        | W 6.2 | 바닐라 커스터드에 커피가 어우러진 쉐이크쉑만의 아포가토 콘크리트
5. Shack in the Garden  | W 6.2 | 바닐라 커스터드에 라즈베리 잼, 쇼트브레드와 말차가 달콤하게 블렌딩된 콘크리트
0. 뒤로가기             | 뒤로가기""")



        //concretes에 입력받은 값 예외처리
        while (true){
            try{
                concretes = readLine()!!.toInt()
                if(concretes !in 0..5){
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


        //뒤로가기를 눌렀을 떄 실행
        if ( concretes == 0){
            return menu()
        }


        //콘크리트를 선택했을 때 주문내역에 추가할지 묻고 추가하면 가격과 콘크리트이름을 출력하고 추가하지 않으면 처음으로 돌아감 + 특정값 이외 예외처리
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
                        orderlist = orderlist.plus(concretesorder[concretes - 1])
                        println("주문내역")
                        println(orderlist.contentToString())
                        pay += concretesorder[concretes + 4].toInt()
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