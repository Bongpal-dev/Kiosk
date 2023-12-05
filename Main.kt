import java.lang.NumberFormatException

val order = Order() //

var money = 50000


fun main() {
    val menuData = MenuData()   // 메뉴 데이터를 가지고 있는 클래스 인스턴스
    val menuSelect = MenuSelect() // 메뉴를 dispaly하고 선택하는 클래스 인스턴스

    while (true) {               // 메뉴 반복
        var menuSelector: Int

        if (order.nowCart.isEmpty()) {        // 장바구니가 비어있으면 메뉴만 출력
            println(
                """
        ===================================  SHAKESHACK MENU  ===================================
        
           1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴
           2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거
           3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드
           4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴
           5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 
        
        ==========================================================================================  
           0. 종료          | 프로그램 종료
         
            """.trimIndent()
            )

            // 숫자 이외의 값이 입력될 경우 Exception을 캐치해 되돌림
            try {
                menuSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (menuSelector) {
                1 -> {menuSelect.addOrder(menuData.bugers)} // 선택한 메뉴별로 데이터 리스트를 전달
                2 -> menuSelect.addOrder(menuData.chicken)
                3 -> menuSelect.addOrder(menuData.custard)
                4 -> menuSelect.addOrder(menuData.concretes)
                5 -> menuSelect.addOrder(menuData.drinks)
                0 -> break
                else -> System.err.println("메뉴를 선택해주세요.")
            }
        } else {
            println("===================================  SHAKESHACK MENU  ===================================\n")
            println("   1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴")
            println("   2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거")
            println("   3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드")
            println("   4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴")
            println("   5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료")
            println("\n==========================================================================================")
            println("   6. Order         | 장바구니를 확인 후 주문합니다.")
            println("   7. Cancel        | 진행중인 주문을 취소합니다.")
            println("==========================================================================================")
            println("   0. 종료          | 프로그램 종료")

            try {
                menuSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (menuSelector) {
                1 -> menuSelect.addOrder(menuData.bugers)
                2 -> menuSelect.addOrder(menuData.chicken)
                3 -> menuSelect.addOrder(menuData.custard)
                4 -> menuSelect.addOrder(menuData.concretes)
                5 -> menuSelect.addOrder(menuData.drinks)
                6 -> order.orderCheck()
                0 -> break
                else -> System.err.println("메뉴를 선택해주세요.")
            }
        }
    }

    println("프로그램을 종료합니다.")

}