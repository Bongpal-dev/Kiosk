fun main() {
    var menu = Menu()
    var bugers = Bugers()
    var chicken = Chicken()
    var custard = Custard()
    var concretes = Concretes()
    var drinks = Drinks()
    var payment = Payment()

    while (true) {
        menu.menu()
        var list = menu.menuNumber

        if (list == 1) {
            bugers.BugMenu()
        } else if (list == 2) {
            chicken.ChicMenu()
        } else if (list == 3) {
            custard.CusMenu()
        } else if (list == 4) {
            concretes.ConMenu()
        } else if (list == 5) {
            drinks.DrkMenu()
        }else if (list == 6){
            payment.payment()
            break
        } else {
            println("프로그램을 종료합니다")
            break
        }
    }
}