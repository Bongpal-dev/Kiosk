package kiosk

class MenuSelection  {

    fun menuDetails (menuListIndex: Int) {
        val menuList = Menus().menuItems[menuListIndex]

        while (true) {
            printMenus(menuList)

            val menuIndex = indexCheck { printMenus(menuList) }

            if (menuIndex !in 0 .. menuList.lastIndex + 1) {
                noExistNumber()
                continue
            }

            if (menuIndex == 0) {
                break
            }

            printSeletMenu(menuList[menuIndex-1])

            val selectCheck = indexCheck { printSeletMenu(menuList[menuIndex-1]) }

            if (selectCheck == 2) {
                continue
            }

            if (selectCheck == 1) {
                println("${menuList[menuIndex-1].name}가 장바구니에 추가되었습니다.\n")
                shoppingCart += menuList[menuIndex-1]
                Thread.sleep(2000L)
                break
            }
            noExistNumber()
        }
    }
    private fun printMenus(menus: ArrayList<MenuItem>) {
        println("===================================================================================")

        for (i in 0 .. menus.lastIndex){
            print("  ${ i + 1 }. ")
            menus[i].displayInfo()
        }

        println("===================================================================================")
        println("  [0] 뒤로가기")
    }

    private fun printSeletMenu(menu: MenuItem) {
        println("\n===================================================================================")
        menu.displayInfo()
        println("===================================================================================")
        println("  이 메뉴를 장바구니에 추가하시겠습니까?")
        println("  [1] 예    [2] 아니오")
    }
}