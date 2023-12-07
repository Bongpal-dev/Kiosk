﻿package kiosk

import kotlinx.coroutines.*
import java.lang.NumberFormatException

val orderMenu = OrderMenu()
var standByOrder = arrayListOf<List<Menu>>()
var money = 500


fun main() {
    val menuData = MenuData()   // 메뉴 데이터를 가지고 있는 클래스 인스턴스
    val selectMenu = SelectMenu() // 메뉴를 dispaly하고 선택하는 클래스 인스턴스
    val couponMenu = CouponMenu()

    val globalScope = GlobalScope

    globalScope.launch {
        while (true) {
            delay(5000L)
            println("(주문 대기 : ${standByOrder.size}명)")
        }
    }

//    timer(daemon = true, initialDelay = 100L, period = 5000L) {
//    }

    while (true) {               // 메뉴 반복

        var mainMenuSelect: Int

        println(
                """
    ===================================  SHAKESHACK MENU  ===================================
    
       1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴
       2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거
       3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드
       4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴
       5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 
    
   ==========================================================================================
       6. Order         | 장바구니를 확인 후 주문합니다.
       7. Cancel        | 진행중인 주문을 취소합니다.
       8. Coupon        | 할인쿠폰을 확인합니다.
   ==========================================================================================
       0. 종료          | 프로그램 종료
     
        """.trimIndent()
            )

            try {
                mainMenuSelect = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                Thread.sleep(2000)
                continue
            }

            when (mainMenuSelect) {
                1 -> selectMenu.addOrder(menuData.bugers)
                2 -> selectMenu.addOrder(menuData.chicken)
                3 -> selectMenu.addOrder(menuData.custard)
                4 -> selectMenu.addOrder(menuData.concretes)
                5 -> selectMenu.addOrder(menuData.drinks)
                6 -> orderMenu.orderCheck()
//                7 ->
                8 -> couponMenu.couponUse()
                0 -> break
                else -> System.err.println("메뉴를 선택해주세요.")
            }
        }

    println("프로그램을 종료합니다.")
}

fun priceConvert (p: Int): String {
    return "${p / 10}.${p % 10}"
}

fun intCheck (): Int {
    while (true) {
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            System.err.println("숫자만 입력해주세요.")
            Thread.sleep(2000)
            continue
        }
    }
}