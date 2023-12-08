package kiosk

import kiosk.DataType.DeliveryOrder
import java.lang.NumberFormatException
import kotlinx.coroutines.*

val messages = Strings().messages
var shoppingCart = arrayListOf<MenuItem>()
var coupons = arrayListOf<Coupons>()
var orders = arrayListOf<ArrayList<MenuItem>>()
var deliveryOrder = arrayListOf<DeliveryOrder>()
var paymentAmount = 0
var money = 50000

fun main() {
    backgroundWork()
    mainMenu()
}

fun mainMenu() {
    while (true) {
        messages[0].forEach { println(it) }

        var mainMenuIndex = indexCheck { messages[0].forEach { println(it) } }

        when (mainMenuIndex) {
            0 -> {
                break
            }
            in 1..9 -> {
                mainMenuDetails(mainMenuIndex)
                continue
            }
            else -> {
                noExistNumber()
            }
        }
    }
    println("프로그램을 종료합니다.")
}

fun mainMenuDetails(index: Int) {
    when (index) {
        1 -> MenuSelection().menuDetails(0)
        2 -> MenuSelection().menuDetails(1)
        3 -> MenuSelection().menuDetails(2)
        4 -> MenuSelection().menuDetails(3)
        5 -> MenuSelection().menuDetails(4)
        6 -> ShoppingCart().shoppingCartDetails()
        8 -> CouponActions().actions()
        9 -> Delivery().deliveryCheck()
    }
}

fun backgroundWork() {
    coroutineLooperOperate(5000L) {
        println("\r(주문 대기 : ${orders.size}명)")
    }
    coroutineLooperOperate(10000L) {
        println("배달의 민족 주문~♪")
        Delivery().orderDelivery()
    }
}

fun coroutineLooperOperate(time: Long, action: () -> Unit) {
    GlobalScope.launch(Dispatchers.Default) {
        while (true) {
            delay(time)
            action()
        }
    }
}

fun priceConverter (p: Int): String {
    if (p == 0) {
        return "￦ 0.0"
    }
    var result = StringBuilder(p.toString())

    result.insert(result.lastIndex-2, '.').deleteAt(result.lastIndex)

    if (result.last() == '0') {
        result.deleteAt(result.lastIndex)
    }

    if (result.length < 3) {
        result.insert(0, '0')
    }

    return "￦ ${result.toString()}"
}

fun indexCheck(action: () -> Unit): Int {
    while (true) {
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            System.err.println("숫자만 입력해주세요.\n")
            Thread.sleep(500L)
            action()
            continue
        }
    }
}
fun noExistNumber () {
    System.err.println("선택하신 메뉴가 없습니다.")
    Thread.sleep(500L)
}