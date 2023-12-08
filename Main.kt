import bugers.Burgers
import bugers.Hamburger
import bugers.ShackBurger
import bugers.ShackStack
import bugers.ShroomBurger
import bugers.SmokeShack
import chicken.Chicken
import chicken.ChickenBites
import chicken.ChickenShack
import chicken.HotChicken
import concretes.Better2Gether
import concretes.Concretes
import concretes.HoneyButterCrunch
import concretes.ShackAttack
import concretes.ShackFfogato
import concretes.ShackInTheGarden
import coupon.Coupon
import custard.ClassicHandSpunShakes
import custard.CupCones
import custard.Custard
import custard.Floats
import drinks.AbitaRootBeer
import drinks.Drinks
import drinks.FiftyFifty
import drinks.FountainSoda
import drinks.FreshBrewedIcedTea
import drinks.HotTea
import drinks.Lemonade
import wallet.Wallet
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import kotlin.concurrent.timer

val orderList = arrayListOf<Menu>()
var orderState = false
val wallet = Wallet()
var coupon: Coupon? = null

fun main() {
    val timer = timer(period = 5000) {
        // 프로그램을 종료시켜도 계속 타이머가 돌아감 -> timer를 cancle()
        println("=========== 현재 주문 대기수<${orderList.size}> ===========")
    }
    while (true) {
        try {
            orderState = if (orderList.isEmpty()) {
                showMenu()
                false
            } else {
                showMenuWithOrder()
                true
            }
            when(readLine()!!.toInt()) {
                1 -> {
                    val burgers = arrayListOf<Menu>(ShackBurger(), SmokeShack(), ShroomBurger(), ShackStack(),Hamburger())
                    if (menuInfo(burgers)) continue
                }
                2 -> {
                    val chickens = arrayListOf<Menu>(HotChicken(), ChickenShack(), ChickenBites())
                    if (menuInfo(chickens)) continue
                }
                3 -> {
                    val custards = arrayListOf<Menu>(ClassicHandSpunShakes(), Floats(), CupCones())
                    if (menuInfo(custards)) continue
                }
                4 -> {
                    val concretes = arrayListOf<Menu>(ShackAttack(), HoneyButterCrunch(), Better2Gether(), ShackFfogato(), ShackInTheGarden())
                    if (menuInfo(concretes)) concretes
                }
                5 -> {
                    val drinks = arrayListOf<Menu>(Lemonade(), FreshBrewedIcedTea(), FiftyFifty(), FountainSoda(), AbitaRootBeer(), HotTea())
                    if (menuInfo(drinks)) continue
                }
                6-> {
                    Thread.sleep(3000)
                    if (orderState) {
                        if (!orderFlow()) continue
                    } else {
                        println("잘못 입력하였습니다 다시 입력해주세요!")
                        Thread.sleep(3000)
                    }
                }
                7-> {
                    Thread.sleep(3000)
                    if (orderState) {
                        println("진행중인 주문이 모두 취소되었습니다")
                        orderList.clear()
                    } else {
                        println("잘못 입력하였습니다 다시 입력해주세요!")
                    }
                }
                8 -> {
                    // 쿠폰
                    showCouponMenu()
                }
                9 -> {
                    // 배달 주문 생성 메뉴
                }
                0 -> {
                    println("종료되었습니다!")
                    timer.cancel()
                    return
                }
                else -> {
                    println("잘못 입력하였습니다 다시 입력해주세요!")
                    Thread.sleep(3000)
                }
            }
        } catch (e: Exception) {
            println("번호를 다시 입력해주세요!")
            Thread.sleep(3000)
        }
    }
}

private fun showMenu() {
    println("\nSHAKESHACK BURGER 에 오신걸 환영합니다")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요!")
    println("1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴\n" +
            "2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거\n" +
            "3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드\n" +
            "4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴\n" +
            "5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 \n" +
            "=========================================================================== \n" +
            "8. COUPON        | 쿠폰을 발급받아서 할인되 가격을 만나보세요! \n" +
            "=========================================================================== \n" +
            "0. 종료          | 프로그램 종료"
    )
}

private fun showMenuWithOrder() {
    println("\nSHAKESHACK BURGER 에 오신걸 환영합니다")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요!")
    println("[ SHAKESHACK MENU ]\n" +
            "1. BURGERS       | 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴\n" +
            "2. CHICKEN       | 신선한 치킨 통살을 버터밀크에 수비드 튀긴 프리미엄 치킨 버거\n" +
            "3. CUSTARD       | 매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드\n" +
            "4. CONCRETES     | 커스터드와 다양한 믹스-인이 만나 탄생한 쉐이크쉑만의 디저트 메뉴\n" +
            "5. DRINKS        | 매장에서 직접 만드는 쉐이크쉑의 음료 \n" +
            "0. 종료          | 프로그램 종료"
    )
    println("[ ORDER MENU ]\n" +
            "6. Order       | 장바구니를 확인 후 주문합니다.\n" +
            "7. Cancel      | 진행중인 주문을 취소합니다.\n" +
            "=========================================================================== \n" +
            "8. COUPON        | 쿠폰을 발급받아서 할인되 가격을 만나보세요! \n" +
            "=========================================================================== \n")
}

private fun menuInfo(menus: ArrayList<Menu>): Boolean {
    Thread.sleep(3000)
    for ((i, menu) in menus.withIndex()) {
        print("${i + 1}   ")
        menu.descriptionMenu()
    }
    println("0. 뒤로가기       | 뒤로가기")
    val select = readLine()!!.toInt()
    Thread.sleep(3000)
    if (select == 0) return true
    else {
        selectMenu(select, menus)
    }
    return false
}

private fun selectMenu(select: Int, menus: ArrayList<Menu>) {
    val menu = menus[select-1]
    menu.descriptionMenu()
    println("위 메뉴를 장바구니에 추가하시겠습니까?")
    println("1. 확인        2. 취소")
    when(readLine()!!.toInt()) {
        1 -> {
            Thread.sleep(3000)
            orderList.add(menu)
            println("${menu.name}가 장바구니에 추가되었습니다.")
        }
        2 -> {
            Thread.sleep(3000)
            println("장바구니가 취소되었습니다!")
        }
    }
}

private fun orderFlow(): Boolean {
    var price = 0.0
    println("아래와 같이 주문 하시겠습니까?\n")
    println("[ Orders ]")
    for (order in orderList) {
        order.descriptionMenu()
        price += order.price
    }
    println("\n[ Total ]")
    println("W $price")
    println("\n1. 주문      2. 메뉴판\n")
    if (readLine()!!.toInt() == 1) {
        if (!checkTime()) {
            Thread.sleep(3000)
            wallet.buyMenu(price, coupon)
            orderList.clear()
        } else {
            println(
                "현재 시각은 ${
                    LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
                }"
            )
            println("은행 점검 시간은 오후11시 10분 ~ 오후 11시 20분이므로 결제할 수 없습니다.")
        }
    } else {
        Thread.sleep(3000)
        return false
    }
    return true
}

private fun checkTime(): Boolean {
    val currentTime = LocalTime.now()
    return currentTime in (LocalTime.of(23, 10)..LocalTime.of(23, 20))
}

private fun showCouponMenu(){
    println("[주의!] 쿠폰은 하나만 발급 받을 수 있으며, 쿠폰의 할인율은 랜덤입니다.\n " +
            "쿠폰 재발급 시 이전의 쿠폰은 자동으로 삭제 됩니다. "+
            "2만원 이상 구매 시 자동으로 쿠폰이 적용됩니다")
    println("\n[1] 쿠폰 발급받기   [2] 돌아가기")

    while(true) {
        try {
            when(readLine()!!.toInt()) {
                // 쿠폰 발급 이미 있던 쿠폰과 교체! coupon을 null로 선언하고, 2만원 이상 사용시 coupon null 체크를 하여 coupon이 있을 때만 쿠폰 적용
                1 -> {
                    coupon = Coupon()
                    break
                }
                2 -> break
                else -> println("잘못 입력하였습니다 다시 입력해주세요!")
            }
        }catch (e: Exception) {
            println("번호를 다시 입력해주세요!")
        }
    }

}
