package kiosk

class CouponMenu {

    var couponList = mutableListOf<Coupon>()

    fun couponUse () {

        var couponMenuSelector: Int

        while (true) {
            println("==========================================================================================")
            println("    1. My Coupon         | 사용가능한 할인쿠폰 내역을 확인합니다.")
            println("    2. New Coupon        | 새로운 할인쿠폰을 발급받습니다.")
            println("==========================================================================================")
            println("    0. 뒤로가기          | 메인화면으로 돌아갑니다.\n")

            try {
                couponMenuSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (couponMenuSelector) {

                1 -> myCoupon()

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
            println("  [0] 뒤로가기")

            try {
                myCouponSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요")
                continue
            }

            when (myCouponSelector) {

                0 -> return
            }

        }
    }

    fun newCoupon () {
        var randomCoupon = listOf<Int>(100, 300, 500)
        var discountRate = randomCoupon.random()
        println("${discountRate / 10}% 할인쿠폰이 발급됐습니다.")
        couponList += Coupon("${discountRate / 10}% 할인쿠폰", discountRate)
    }

}