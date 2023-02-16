package Cars
import java.awt.Color

class Sedan : Car("X34Z201-V", "Toyota", "Camry", 531240, 4, 2015) {

    init {
        X().name=""
        print("Type of car registered is ${getType()}: $model ($year) - Color ${getColor()}")
    }

    override fun setWheelNumber(): Int { return 4 }
    override fun gasType(): String { return "Petrol" }
}