package kiosk

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class OrderMenu {
    var nowCart = mutableListOf<Menu>()
    var nowCoupon = mutableListOf<Coupon>()
    fun orderCheck() {
        // 현재시간과 은행 점검시간
        val nowTime = LocalDateTime.now()
        val bankCheck = (LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0)) ..LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 20)))

        // 결제시 총 금액 안내용
        var totalPrice = nowCart.sumOf { it.price }


        if (nowCart.isEmpty()) {
            println("장바구니가 비어있습니다.\n")
            Thread.sleep(1500L)
            return
        }

        orderLoop@ while (true) {
            println("==========================================================================================\n")
            for (i in 0 .. nowCart.lastIndex) {
                println("${i + 1}. ${nowCart[i].name} - ￦ ${priceConvert(nowCart[i].price)}")
            }
            println("\n==========================================================================================")
            println("  선택한 상품 : ${nowCart.size}개        Total : ￦ ${priceConvert(totalPrice)}")
            println("==========================================================================================")
            println("\n선택하신 내용대로 주문하시겠습니까?")
            println("   [1] 예    [2] 아니오    [3] 장바구니 비우기")

            var orderYesOrNo = intCheck()

            when (orderYesOrNo) {
                1 -> {

                    if (nowTime in bankCheck) {
                        System.err.println("은행 점검시간은 22시 00분 ~ 22시 20분 입니다.")
                        System.err.println("현재시각은 ${nowTime.hour}시 ${nowTime.minute}분 입니다.")
                        Thread.sleep(3000L)
                        continue
                    }


                    if (couponMenu.couponList.isNotEmpty()) {
                        while (true) {

                            if (totalPrice < 20000) break

                            println("\n할인쿠폰을 사용하시겠습니까?")
                            println("   [1] 예    [2] 아니오")

                            var couponUseYesOrNo = intCheck()


                            when (couponUseYesOrNo) {
                                1 -> {
                                    useCoupon(totalPrice)
                                    break
                                }
                                2-> break
                                else -> {
                                    System.err.println("잘못된 입력입니다.")
                                    continue
                                }
                            }
                        }
                    }

                    if (nowCoupon.isNotEmpty()) totalPrice -= (totalPrice / 1000 * nowCoupon.first().discountRate)

                    if (totalPrice > money) {
                        println("\n잔액이 부족합니다.")
                        println("\n현재 잔액 : ￦ ${priceConvert(money)}     부족 금액 : ￦ ${priceConvert(totalPrice - money)}\n")
                        Thread.sleep(2_000)
                        continue
                    }

                    money -= totalPrice
                    print("\n결제가 완료됐습니다.")
                    println(" (${nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))})")
                    println("\n현재 잔액 : ￦ ${priceConvert(money)}\n")
                    standByOrder += nowCart.toList()
                    nowCart.clear()
                    Thread.sleep(2_000)
                    break
                }

                2 -> break

                3 -> {
                    while (true){
                        println("주문중인 내역을 모두 삭제할까요?")
                        println("[1] 예    [2] 아니오")

                        var cartReset = readln().toInt()

                        when (cartReset) {
                            1 -> {
                                nowCart.clear()
                                println("주문중인 내역이 모두 삭제되었습니다.")
                                Thread.sleep(2000L)
                                break@orderLoop
                            }

                            2-> break

                            else -> {
                                System.err.println("잘못된 입력입니다.")
                                continue
                            }
                        }
                    }
                }

                else -> {
                    System.err.println("잘못된 입력입니다.")
                    continue
                }
            }
        }
    }

    fun useCoupon (total: Int) {
        var useableCoupon = couponMenu.couponList

        useCouponLoop@ while (true) {
            println("========= Coupon List =========\n")

            for (num in 0..useableCoupon.lastIndex) {
                println("    [${num + 1}] ${useableCoupon[num].name}")
            }

            println("\n==============================\n")
            println("사용하실 쿠폰을 선택해주세요.  [0] 취소하기")

            var useCouponSelector = intCheck()

            if (useCouponSelector !in 0 .. useableCoupon.size) {
                System.err.println("잘못된 입력입니다.")
                continue
            }

            if (useCouponSelector == 0) break

            nowCoupon.clear()
            nowCoupon += useableCoupon[useCouponSelector - 1]

            while (true) {

                println("\n==========================================================================================")
                println("  적용전 금액 : ￦ ${priceConvert(total)}      ${useableCoupon[useCouponSelector - 1].name} 적용시 : ￦ ${priceConvert(total - (total/1000 * nowCoupon.first().discountRate) )}")
                println("==========================================================================================")
                println("   [1] 결제하기    [2] 뒤로가기")
                var couponUseYesOrNo = intCheck()

                when (couponUseYesOrNo) {
                    1 -> {
                        println("쿠폰이 적용됐습니다.")
                        couponMenu.couponList.removeAt(useCouponSelector - 1)
                        break@useCouponLoop
                    }

                    2 -> continue@useCouponLoop

                    else -> {
                        System.err.println("잘못된 입력입니다.")
                        continue
                    }
                }
            }



        }
    }


}