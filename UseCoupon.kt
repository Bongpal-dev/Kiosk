package kiosk
class UseCoupon () {
    var discountPrice = 0
    fun couponUseCheck(): Boolean {
        while (true) {
            strings.messages[3].forEach { println(it) }

            var couponUseCheck = immutableIndexCheck(3)

            when (couponUseCheck) {
                1-> {
                    if (whichCouponUse()) continue else return true
                }
                2-> return false
                else -> {
                    noExistNumber()
                    continue
                }
            }
        }


    }

    fun whichCouponUse (): Boolean {
        var selectedCoupon: Coupons

        whichCoupon@ while (true) {
            printCoupons()

            var useCouponIndex = mutableIndexCheck { printCoupons() }

            when (useCouponIndex) {
                0 -> return true
                !in 0 .. coupons.size -> {
                    noExistNumber()
                    continue
                }
            }

            selectedCoupon = coupons[useCouponIndex - 1]

            if (selectedCoupon.minimunAmount > paymentAmount) {
                println("해당쿠폰은 결제금액 ${priceConverter(selectedCoupon.minimunAmount)} 이상만 사용 가능합니다.\n")
                Thread.sleep(1500L)
                continue
            }

            while (true) {
                printDiscountResult(selectedCoupon)

                var paymentWithCoupon = mutableIndexCheck { printDiscountResult(selectedCoupon) }

                if (paymentWithCoupon == 2) {
                    continue@whichCoupon
                }

                if (paymentWithCoupon == 1) {
                    println("쿠폰이 적용됐습니다.")
                    paymentAmount -= discountPrice
                    coupons.removeAt(useCouponIndex - 1)
                    return false
                }
                noExistNumber()
                continue
            }
        }
    }

    fun printCoupons() {
        println("=============== Coupon List ===============")

        for (j in 0..coupons.lastIndex) {
            println("    ${j + 1}. ${coupons[j].name}")
        }
        println("===========================================")
        println("  [0] 취소하기")
    }

    fun printDiscountResult(sc: Coupons) {
        discountPrice = paymentAmount * sc.discountRate / 10000 * 100

        println("\n==========================================================================================")
        println("  적용전 금액 : ${priceConverter(paymentAmount)}")
        println("  ${sc.name} 적용시 : ${priceConverter(paymentAmount - discountPrice)}")
        println("==========================================================================================")
        println("   [1] 결제하기    [2] 취소하기")
    }

}