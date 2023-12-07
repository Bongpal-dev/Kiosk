package wallet

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.round
import kotlin.math.roundToInt

class Wallet {

     private var money: Double = 10.0
     fun buyMenu(cost: Double) {
          if (money >= cost) {
               money -= cost
               print("결제를 완료했습니다. ")
               println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
               println("구입 후 남은 잔액은 ${(money * 100.0).roundToInt() / 100.0}W 입니다.")
          } else {
               val overPay = cost - money
               println("현재 잔액은 ${money}W 으로 ${(overPay * 100.0).roundToInt() / 100.0}W 부족해서 주문할 수 없습니다.")
               // 여기서 cost - money를 했을 때, 소숫점 자릿수 조정이 필요할듯 왜 소수점이 많이 나오는지 모르겠음
          }
     }
}