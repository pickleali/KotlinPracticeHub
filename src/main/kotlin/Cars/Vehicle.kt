package Cars

// import java.util.HexFormat
import kotlin.random.Random

abstract class Vehicle(
    var vin: String,
    var brand: String,
    var model: String,
    // todo: change color to Hex(inside hex convert from byte to Hex
    //       and show the quivalent color in Hex '#fff -> white') - optional.
    var color: Int,
    var type: Int?,
    var year: Int
) {

    // companion object is an object definied inside the class itself.
    // instead of creating 'object class', it can be defined inside.
    // The difference between object class (in general) and class is the following:
    // No need to create an instance of an object class to reach to its methods/variables.
    // As for class itself, if you want to access method within the class, you have to reach to that method from the instance.
    companion object{
        fun randomCar(): Int{
            val randomValue = Random.nextInt(1,5)
            return randomValue
        }
    }
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
