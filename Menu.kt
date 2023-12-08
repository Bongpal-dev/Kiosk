// menu.kt

data class MenuItem(val name: String, val price: Int)

val burgerMenu = listOf(
    MenuItem("빅맥", 5000),
    MenuItem("상하이 스파이시 치킨버거", 4500),
    MenuItem("1955버거", 4000)
)

val drinkMenu = listOf(
    MenuItem("콜라", 1500),
    MenuItem("사이다", 1500),
    MenuItem("아이스티", 2000)
)

val sideMenu = listOf(
    MenuItem("감자튀김", 2000),
    MenuItem("치즈스틱", 3000),
    MenuItem("맥플러리", 2500)
)
