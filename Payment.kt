class Payment {
    var paying = 0


    fun payment(){
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
    }
}