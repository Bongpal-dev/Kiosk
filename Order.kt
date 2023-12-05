import java.lang.NumberFormatException
import java.text.DecimalFormat
import kotlin.math.round

class Order {
    var nowCart = mutableListOf<Menu>()

    fun orderCheck() {
        var totalPrice = 0

        nowCart.forEach{totalPrice += it.price}


        while (true) {
            println("==========================================================================================\n")
            for (i in 0 .. nowCart.lastIndex) {
                println("${i + 1}. ${nowCart[i].name} - ￦ ${nowCart[i].price / 100}")
            }
            println("\n==========================================================================================")
            println("  선택한 상품 : ${nowCart.size}개        Total : ￦ ${totalPrice / 100}")
            println("==========================================================================================")
            println("\n선택하신 내용대로 주문하시겠습니까?")
            println("   [1] 예    [2] 아니오")

            var orderYesOrNo: Int

            try {
                orderYesOrNo = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            when (orderYesOrNo) {
                1 -> {
                    if (totalPrice > money) {
                        println("\n잔액이 부족합니다.")
                        println("\n현재 잔액 : ￦ ${money / 100}     부족 금액 : ￦ ${(totalPrice - money) / 100}\n")
                        continue
                    } else {
                        money -= totalPrice
                        println("\n결제가 완료됐습니다.")
                        println("\n현재 잔액 : ￦ ${money / 100}\n")
                        nowCart.clear()
                        Thread.sleep(2_000)
                        break
                    }
                }
                2 -> break
                else -> {
                    System.err.println("잘못된 입력입니다.")
                    continue
                }
            }
        }
    }
}