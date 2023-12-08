package kiosk

class ShoppingCart {


    fun shoppingCartDetails() {
        paymentAmount = shoppingCart.sumOf { it.price }

        if (shoppingCart.isEmpty()) {
            println("장바구니가 비어있습니다.\n")
            Thread.sleep(1500L)
            return
        }

        while (true) {
            printShoppingCartDetails()

            val shoppingCartIndex = mutableIndexCheck { printShoppingCartDetails() }

            when (shoppingCartIndex) {
                0 -> return
                1 -> break
                2 -> {
                    var resetStatus = resetCart()
                    if (resetStatus) continue else return
                }
                else -> {
                    noExistNumber()
                    continue
                }
            }
        }
        Payment().pay()
    }

    fun printShoppingCartDetails() {
        println("===================================================================================")

        for (i in 0..shoppingCart.lastIndex) {
            println("${i + 1}. ${shoppingCart[i].name} - ${priceConverter(shoppingCart[i].price)}")
        }
        println("===================================================================================")
        println("선택한 상품 : ${shoppingCart.size}개        Total : ${priceConverter(paymentAmount)}")
        println("===================================================================================")
        println("선택하신 내용대로 주문하시겠습니까?")
        println("[1] 예    [2] 장바구니 비우기    [0] 뒤로가기")
    }

    fun resetCart(): Boolean {
        while (true) {
            strings.messages[1].forEach { println(it) }

            val shoppingCartResetCheck = immutableIndexCheck(1)

            if (shoppingCartResetCheck == 2) {
                return true
            }

            if (shoppingCartResetCheck == 1) {
                shoppingCart.clear ()
                println("\n장바구니를 비웠습니다.\n")
                Thread.sleep(1500L)
                return false
            }
            noExistNumber()
        }
    }
}