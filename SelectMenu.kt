package kiosk

import java.lang.NumberFormatException

class SelectMenu  {

    fun addOrder (menu: List<Menu>) {

        addOrderLoop@ while (true) {

            // 각 메뉴리스트를 전달 받아서 화면에 보여줌

            println("==========================================================================================")
            for (i in menu) {
                println("${menu.indexOf(i) + 1}. ${i.name} - ￦ ${priceConvert(i.price)}")
                println("   ${i.explain}\n")
            }
            println("==========================================================================================")
            println("0. 뒤로가기\n")

            // 메뉴를 선택
            var orderSelector: Int

            try {
                orderSelector = readln().toInt()
            } catch (e: NumberFormatException) {
                System.err.println("숫자만 입력해주세요.")
                continue
            }

            if (orderSelector !in 0 .. menu.lastIndex + 1) {    // 받아온 메뉴리스트의 index 이외의 값이 입력될 경우 루프를 되돌림
                System.err.println("선택하신 메뉴가 없습니다.")
                continue
            } else if (orderSelector == 0) {    // 0을 입력하면 루프를 벗어나고 main으로 돌아감

                break

            } else {      // 메뉴에 있는 index가 입력되면 (해당번호 - 1)값으로 메뉴들을 출력 (인덱스 번호는 입력 숫자보다 1 작기때문에)

                println("\n==========================================================================================")
                println("   ${menu[orderSelector - 1].name} - ￦ ${priceConvert(menu[orderSelector - 1].price)}")
                println("   ${menu[orderSelector - 1].explain}")
                println("==========================================================================================\n")
                println("이 메뉴를 장바구니에 추가하시겠습니까?")
                println("   [1] 예    [2] 아니오")

                var yesOrNo: Int

                while (true) {
                    try {
                        yesOrNo = readln().toInt()
                    } catch (e: NumberFormatException) {
                        System.err.println("숫자만 입력해주세요.")
                        continue
                    }

                    when (yesOrNo) {

                        1 -> {
                            println("${menu[orderSelector - 1].name}가 장바구니에 추가되었습니다.\n")    // 예 선택시 해당 item이 추가됐다는 메세지를 출력
                            orderMenu.nowCart += menu[orderSelector - 1]    // 전역변수에 있는 현재 목록에 해당 값 (Menu타입)을 추가
                            Thread.sleep(1500L)
                            break@addOrderLoop // 메뉴 화면으로 돌아감
                        }

                        2 -> {
                            break      // 아니오 선택시 루프 반복 (현재 메뉴를 다시 보여줌, main으로 가는게 아님)
                        }

                        else -> {
                            System.err.println("잘못된 입력입니다.")
                        }
                    }
                }
            }
        }
    }
}