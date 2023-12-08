package kiosk.DataType

data class DeliveryOrder(
    val price: Int,
    val menus: ArrayList<String>,
    val latitude: Double,
    val longitude: Double
)
