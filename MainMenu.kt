open class Menu(){
    var A = 0
    var pay = 0
    var check = 0
    var orderlist = arrayOf<String>()

    fun menu(){
        println("""1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴
2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거
3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드
4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴
5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 
0. 종료          | 프로그램 종료""")
        while(true){
            try{
                A = readLine()!!.toInt()
                if (A !in 0..5){
                    println("다시 입력해주세요")
                }else{
                    break
                }
            }
            catch(e : Exception, ){
                println("다시 입력해주세요")
            }
        }
    }
}