package coupon

import kotlin.properties.Delegates

class Coupon(private var discount: Int = 0) {
    init {
        val discountRate = arrayListOf<Int>(10,15,20,25,30)
        discount = discountRate.random()
    }
    fun useCoupon(cost: Double): Double {
        return cost * (1 - discount/100.0)
    }
}