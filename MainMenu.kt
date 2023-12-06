open class Menu(){
    //메뉴 앞에 있는 번호를 받는 변수
    var menuNumber = 0



    //제품을 선택할지의 여부를 확인하는 변수
    var check = 0



    //제품 종류를 출력하고 앞의 번호를 받아 상세정보로 들어가도록 하는 함수
    fun menu(){
        println("""1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴
2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거
3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드
4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴
5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 
6. 계산          | 계산하기
0. 종료          | 프로그램 종료""")

        //제품 앞의 번호를 받을 떄 특정숫자가 아니면 예외처리
        while(true){
            try{
                menuNumber = readLine()!!.toInt()
                if (menuNumber !in 0..6){
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