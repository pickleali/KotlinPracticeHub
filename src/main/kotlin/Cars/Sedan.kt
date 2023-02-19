package Cars

class Sedan : Vehicle("X34Z201-V", "Toyota", "Camry", 531240, 4, 2015) {

    init {
        X().name=""
        println("Type of car registered is ${getType()}: $model ($year) - Color ${getColor()}")
    }

    override fun setWheelNumber(): Int { return 4 }
    override fun gasType(): String { return "Petrol" }
    fun filterByYear(): Boolean {
        if (year in 2000..2023)
            return true
        return false
    }
}

fun main() {
    val bicycleAnonymousClass = object : Vehicle("empty", "Canyon", "Hybrid", 4, null, 2023) {
        override fun setWheelNumber(): Int { return 4 }
        override fun gasType(): String { return "Eco-friendly :)" }
        init {
            print("Bicycle with ${setWheelNumber()} wheels (especially $brand brand) is ${gasType()}")
        }
    }


}