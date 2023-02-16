package Cars

import java.util.HexFormat

abstract class Car(
    var vin: String,
    var brand: String,
    var model: String,
    // todo: change color to Hex(inside hex convert from byte to Hex
    //       and show the quivalent color in Hex '#fff -> white') - optional.
    var color: Int,
    var type: Int,
    var year: Int
) {
//    val hex = HexFormat.of()
    val typeMap = mapOf(
        1 to "SUV",
        2 to "Pickup",
        3 to "Coupe",
        4 to "Sedan",
        5 to "Van/Minivan")//.toList()


    fun getColor(): String? { return Integer.toHexString(color) }
    fun getType(): String? { return typeMap.get(type) }
    abstract fun setWheelNumber(): Int
    abstract fun gasType(): String
}

data class X(
    var name : String ="Ali" ,
    var age : Int ?= null,
    val dob : String="10/10/2010")
