// main.kt

fun main() {
    println("안녕하세요! 맥도날드입니다! 주문을 도와드리겠습니다!")

    // 초기 메뉴 표시
    displayCategory()

    // 사용자 입력 받기
    val userInput = readLine()

    // 사용자 입력 처리
    processInput(userInput)
}

fun displayCategory() {
    println("주문하실 메뉴 카테고리를 선택해주세요:")
    println("1. 햄버거")
    println("2. 음료수")
    println("3. 사이드 메뉴")
    println("4. 종료")
    println("원하는 카테고리의 번호를 입력해주세요:")
}

fun displayMenu(menu: List<MenuItem>) {
    println("${menu.first().name} 메뉴:")
    menu.forEachIndexed { index, item ->
        println("${index + 1}. ${item.name} - ${item.price}원")
    }
    println("${menu.size + 1}. 뒤로 가기")
    println("원하는 메뉴의 번호를 입력해주세요!:")
}

fun processInput(input: String?) {
    when (input) {
        "1" -> {
            // 햄버거 카테고리 선택
            displayMenu(burgerMenu)
            val burgerInput = readLine()
            processOrder(burgerMenu, burgerInput)
        }
        "2" -> {
            // 음료수 카테고리 선택
            displayMenu(drinkMenu)
            val drinkInput = readLine()
            processOrder(drinkMenu, drinkInput)
        }
        "3" -> {
            // 사이드 메뉴 카테고리 선택
            displayMenu(sideMenu)
            val sideInput = readLine()
            processOrder(sideMenu, sideInput)
        }
        "4" -> {
            // 프로그램 종료
            println("감사합니다. 오늘도 좋은하루 되세요!")
            System.exit(0)
        }
        else -> {
            // 잘못된 입력
            println("잘못된 입력입니다. 올바른 번호를 입력해주세요.")

        }
    }
}

fun processOrder(menu: List<MenuItem>, userInput: String?) {
    when {
        userInput != null && userInput.toIntOrNull() in 1..menu.size -> {
            val selectedItem = menu[userInput.toInt() - 1]
            println("${selectedItem.name}을 선택하셨습니다. 가격은 ${selectedItem.price}원입니다.")
            confirmOrder(selectedItem)
        }
        userInput == "${menu.size + 1}" -> {
            // 뒤로 가기
            displayCategory()
            val newInput = readLine()
            processInput(newInput)
        }
        else -> {
            println("잘못 입력하셨습니다. 올바른 메뉴 번호를 입력해주세요.")
        }
    }
}

fun confirmOrder(selectedItem: MenuItem) {
    println("주문하시겠습니까? (y/n)")
    val confirmation = readLine()
    when (confirmation?.lowercase()) {
        "y" -> {
            println("${selectedItem.name}을/를 주문하셨습니다. ${selectedItem.price}원을 결제해 주세요. 감사합니다!")
            System.exit(0)
        }
        "n" -> {
            println("${selectedItem.name} 주문이 취소되었습니다. 메뉴로 돌아갑니다.")
            displayCategory()
            val newInput = readLine()
            processInput(newInput)
        }
        else -> {
            println("잘못 입력하셨습니다. 다시 입력해주세요.")
            confirmOrder(selectedItem)
        }
    }
}
