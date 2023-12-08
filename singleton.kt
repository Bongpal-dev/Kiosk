//singleton -> 오직 단 하나만 존재하는 변수라고 생각해도 된다
//따라서 object로 정의 되는 것은 단 하나만 존재하며 거기 안에 값이나 문자를 넣으면 누적되어 오류가 생기지 않는다.



object OrderList{
    var orderlist = arrayOf<String>()
}

object Price{
    var price = 0
}