package kiosk

import kiosk.DataType.DeliveryOrder
import kotlin.random.Random

class Delivery {

    fun orderDelivery(){
        val menus = Menus()
        var deliveryOrders = arrayListOf<MenuItem>()
        var orderMenuNames = arrayListOf<String>()
        var orderPrice = 0
        var Latitude = Random.nextDouble(35.208170, 35.219541)
        var Longitude = Random.nextDouble(129.019343, 129.037572)

        for (i in 0 .. Random.nextInt(5)) {
            val tempMenu = menus.menuItems[Random.nextInt(menus.menuItems.size)]
            deliveryOrders += tempMenu[Random.nextInt(tempMenu.size)]
        }
        deliveryOrders.forEach { orderMenuNames += it.name }
        deliveryOrders.forEach { orderPrice += it.price }
        deliveryOrder += DeliveryOrder(orderPrice, orderMenuNames, Latitude, Longitude)
    }

    fun deliveryCheck () {
        if (deliveryOrder.isEmpty()) {
            println("주문내역이 없습니다.")
            Thread.sleep(1500L)
            return
        }

        while (true) {
            println("================================================  Delivery Order  ================================================\n")

            for (h in 0 .. deliveryOrder.lastIndex) {
                println("${h+1}. 결제금액 : ${priceConverter(deliveryOrder[h].price)}   주문메뉴 : ${deliveryOrder[h].menus.joinToString()}")
                println("   [GPS : ${deliveryOrder[h].latitude}, ${deliveryOrder[h].longitude}]")
            }
            println("\n==================================================================================================================\n")
            println(" 아무 키나 입력하면 메인메뉴로 돌아갑니다.\n")
            readln()
            break
        }
    }

}