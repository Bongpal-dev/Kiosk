class Payment {
    var paying = 0
    var addMoney = 0
    var money = 0


    fun payment(){
        if(OrderList.orderlist.size == 0){
            println("메뉴를 선택한 후 계산해 주세요")
            return main()
        }
        println("현재 소지하신 금액을 입력하세요")
        while(true) {
            try {
                money = readLine()!!.toInt()
                break
            } catch (e: Exception) {
                println("숫자를 정확하게 입력해주세요")
            }
        }
        println("선택하신 제품")
        println(OrderList.orderlist.contentToString())
        println("가격")
        println(Price.price)
        println("계산하시겠습니까?")
        println("네[1], 아니오[2]")
        while(true){
            try{
                paying = readln()!!.toInt()
                if (paying == 1){
                    break
                }else if(paying == 2) {
                    return main()
                }else{
                    break
                }
            }catch(e: Exception){
                println("다시 입력해주세요")
            }
        }
        if (money < Price.price){
            println("잔액이 ${Price.price - money}원 부족합니다")
            println("충전하시겠습니까?")
            println("네 [1], 아니오[2]")
            A@while(true) {
                try {
                    var charge = readLine()!!.toInt()
                    if (charge == 1) {
                        println("충전할 금액을 입력해주세요")
                        B@while(true) {
                            try {
                                addMoney = readLine()!!.toInt()
                                if (addMoney>100000000){
                                    println("충전은 1억 이하로 가능합니다")
                                }else{
                                    B@break
                                }
                            } catch (e: Exception) {
                                println("숫자를 정확히 입력해주세요")
                            }
                        }
                        money += addMoney
                        println("충전되었습니다.")
                        break@A
                    } else if (charge == 2) {
                        println("잔액이 부족해 계산할 수 없습니다. 메뉴로 돌아갑니다.")
                        return Menu().menu()
                    } else {
                        println("다시 입력해주세요")
                    }
                } catch (e: Exception) {
                    println("숫자를 정확히 입력해주세요.")
                }
            }
        }
        money -= Price.price
        println("결제가 완료되었습니다. 남은 잔액 ${money}")
    }
}