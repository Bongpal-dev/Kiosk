import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.NumberFormatException

class Order {
    var nowCart = mutableListOf<Menu>()

    fun orderCheck() {
        val nowTime = LocalDateTime.now()
        val bankCheck = (LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0)) ..LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 20)))
        var totalPrice = 0

        nowCart.forEach{totalPrice += it.price}


        orderLoop@ while (true) {
            println("==========================================================================================\n")
            for (i in 0 .. nowCart.lastIndex) {
                println("${i + 1}. ${nowCart[i].name} - ￦ ${nowCart[i].price / 10}.${nowCart[i].price % 10}")
            }
            println("\n==========================================================================================")
            println("  선택한 상품 : ${nowCart.size}개        Total : ￦ ${priceConvert(totalPrice)}")
            println("==========================================================================================")
            println("\n선택하신 내용대로 주문하시겠습니까?")
            println("   [1] 예    [2] 아니오    [3] 장바구니 비우기")

            var orderYesOrNo: Int

            try {
                orderYesOrNo = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (orderYesOrNo) {
                1 -> {
                    if (nowTime !in bankCheck) {
                        if (totalPrice > money) {
                            println("\n잔액이 부족합니다.")
                            println(
                                "\n현재 잔액 : ￦ ${priceConvert(money)}     부족 금액 : ￦ ${
                                    priceConvert(
                                        totalPrice - money
                                    )
                                }\n"
                            )
                            Thread.sleep(2_000)
                            continue
                        } else {
                            money -= totalPrice
                            print("\n결제가 완료됐습니다.")
                            println(" (${nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))})")
                            println("\n현재 잔액 : ￦ ${priceConvert(money)}\n")
                            nowCart.clear()
                            orderCount++
                            Thread.sleep(2_000)
                            break
                        }
                    } else {
                        System.err.println("은행 점검시간은 22시 00분 ~ 22시 20분 입니다.")
                        System.err.println("현재시각은 ${nowTime.hour}시 ${nowTime.minute}분 입니다.")
                    }
                }
                2 -> break

                3 -> {
                    var cartReset: Int
                    while (true){
                        println("주문중인 내역을 모두 삭제할까요?")
                        println("[1] 예    [2] 아니오")
                        try {
                            cartReset = readln().toInt()
                        } catch (e: NumberFormatException) {
                            System.err.println("숫자만 입력해주세요.")
                            continue
                        }

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

}