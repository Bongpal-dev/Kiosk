package kiosk

import kotlin.random.Random

class CouponActions {

    fun actions() {
        while (true) {
            messages[2].forEach { println(it) }

            var actionIndex = indexCheck { messages[2].forEach { println(it) } }

            when (actionIndex) {
                1 -> couponsDetails()
                2 -> issueCoupon()
                0 -> break
            }
        }
    }

    private fun couponsDetails () {
        if (coupons.isEmpty()) {
            println("사용가능한 쿠폰이 없습니다\n")
            Thread.sleep(1500L)
            return
        }

        while (true) {
            printCoupons()

            var couponIndex = indexCheck { printCoupons() }

            if (couponIndex == 0) {
                break
            }
            noExistNumber()
        }
    }

    private fun issueCoupon () {
        val randomCoupon = listOf<List<Int>>(
            listOf(10, 10000),
            listOf(30, 30000),
            listOf(50, 50000)
        )
        val randomDiscountRate = Random.nextInt(2)
        val discountRate = randomCoupon[randomDiscountRate][0]
        val minimumAmount = randomCoupon[randomDiscountRate][1]

        println("${discountRate}% 할인쿠폰이 발급됐습니다.")
        coupons += Coupons("${discountRate}% 할인쿠폰", discountRate, minimumAmount)
    }

    private fun printCoupons() {
        println("========= Coupon List =========")

        for (num in 0 .. coupons.lastIndex) {
            println("    ${num+1}. ${coupons[num].name}")
        }

        println("==============================")
        println("  [0] 뒤로가기")
    }
}
