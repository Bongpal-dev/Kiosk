package kiosk

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Payment() {
    val bankCheckTime = LocalTime.of(22, 0) .. LocalTime.of(22, 20)

    fun pay(){
        while (true) {
            if (LocalTime.now() in bankCheckTime) {
                printBankCheckTimeErr()
                continue
            }

            if (coupons.isNotEmpty()) {
                UseCoupon().couponUseCheck()
            }

            if (paymentAmount > money) {
                printLowerBalanceErr()
                continue
            }
            money -= paymentAmount
            orders += shoppingCart
            shoppingCart.clear()
            paymentAmount = 0
            printPaymentComplete()
            return
        }
    }

    fun printBankCheckTimeErr() {
        System.err.println("은행 점검시간은 22시 00분 ~ 22시 20분 입니다.")
        System.err.println("현재시각은 ${LocalTime.now().hour}시 ${LocalTime.now().minute}분 입니다.")
        Thread.sleep(2000L)
    }

    fun printLowerBalanceErr() {
        System.err.println("[잔액이 부족합니다].")
        println("부족 금액 : ${priceConverter(paymentAmount - money)}")
        println("현재 잔액 : ${priceConverter(money)}\n")
        Thread.sleep(2000L)
    }

    fun printPaymentComplete() {
        print("\n결제가 완료됐습니다.")
        println(" (${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))})")
        println("\n현재 잔액 : ${priceConverter(money)}\n")
        Thread.sleep(2000L)
    }

}