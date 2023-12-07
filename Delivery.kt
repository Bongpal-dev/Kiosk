package kiosk

import kiosk.DataType.DeliveryOrder
import kotlin.random.Random

class Delivery {

    var nowDelivery = arrayListOf<DeliveryOrder>()
    fun orderDelivery(){
        val menu = MenuData()
        var deliveryMenu = mutableListOf<Menu>()
        var allMenu = mutableListOf<Menu>()

        menu.bugers.forEach { allMenu += it }
        menu.chicken.forEach { allMenu += it }
        menu.concretes.forEach { allMenu += it }
        menu.custard.forEach { allMenu += it }
        menu.drinks.forEach { allMenu += it }

        var menuSize = Random.nextInt(5)

        for (i in 0 .. menuSize) {
            deliveryMenu += allMenu[Random.nextInt(allMenu.size)]
        }

        var orderMenuNames = arrayListOf<String>()
        var orderPrice = 0
        deliveryMenu.forEach { orderMenuNames += it.name }
        deliveryMenu.forEach { orderPrice += it.price }

        var randomLatitude = Random.nextDouble(35.208170, 35.219541)
        var randomLongitude = Random.nextDouble(129.019343, 129.037572)

        nowDelivery += DeliveryOrder(orderPrice, orderMenuNames, randomLatitude, randomLongitude)

    }

    fun deliveryCheck () {
        while (true) {
            println("================================================  Delivery Order  ================================================\n")
            for (h in 0 .. nowDelivery.lastIndex) {
                println("   ${h+1}. 결제금액 : ￦ ${priceConvert(nowDelivery[h].price)}  |   GPS : ${nowDelivery[h].latitude}, ${nowDelivery[h].longitude}  |  주문메뉴 : ${nowDelivery[h].menus.joinToString()}")
            }
            println("\n==================================================================================================================\n")
            println(" 아무 숫자나 입력하면 메인메뉴로 돌아갑니다.\n")

            intCheck()

            break

        }
    }

}