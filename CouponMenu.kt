package kiosk

import kotlin.random.Random

class CouponMenu {

    var couponList = mutableListOf<Coupon>()
    var useCoupon = mutableListOf<Coupon>()

    fun couponUse () {

        var couponMenuSelector: Int

        while (true) {
            println("==========================================================================================")
            println("    1. My Coupon         | 사용가능한 할인쿠폰 내역을 확인합니다.")
            println("    2. New Coupon        | 새로운 할인쿠폰을 발급받습니다.")
            println("    0. 뒤로가기          | 메인화면으로 돌아갑니다.")
            println("==========================================================================================\n")

            try {
                couponMenuSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (couponMenuSelector) {

                1 -> {
                    myCoupon()
                    break
                }

                2 -> newCoupon()

                0 -> break
            }
        }
    }

    fun myCoupon () {

        if (couponList.isEmpty()) {
            println("사용가능한 쿠폰이 없습니다\n")
            Thread.sleep(1500L)
            return
        }

        while (true) {
            var myCouponSelector: Int

            println("========= Coupon List =========\n")

            for (num in 0 .. couponList.lastIndex) {
                println("    ${num+1}. ${couponList[num].name}")
            }

            println("\n==============================\n")
            println("  [1] 쿠폰 사용하기    [2] 메인화면")

            try {
                myCouponSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요")
                continue
            }

            when (myCouponSelector) {
                1 -> couponUse()
                2 -> return
            }

        }
    }

    fun newCoupon () {
        var randomCoupon = listOf<Int>(10, 30, 50)
        var discountRate = randomCoupon.random()
        println("${discountRate}% 할인쿠폰이 발급됐습니다.")
        couponList += Coupon("${discountRate}% 할인쿠폰", discountRate)
    }

    fun useCoupon () {
        var useCouponSelector: Int

        while (true) {
            println("========= Coupon List =========\n")

            for (num in 0..couponList.lastIndex) {
                println("    ${num + 1}. ${couponList[num].name}")
            }

            println("\n==============================\n")
            println("사용하실 쿠폰을 선택해주세요.")

            try {
                useCouponSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요")
                continue
            }

            if (useCouponSelector !in 1 .. couponList.size) {
                System.err.println("해당번호의 쿠폰이 없습니다.")
                continue
            }

        }

    }


}