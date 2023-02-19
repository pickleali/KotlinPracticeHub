import Cars.Sedan
import java.lang.NumberFormatException
import kotlin.math.pow

fun main() {

/*    val userList = listOf(3, 2, 5, 1, 5, 6, 7)
    val result = largestItem(userList)
    val x = Article("medium", "SaaS", "latest")
    val y = Article("hackernews", "AI", "top")
    y.articleOfTheDay()
    val car1 = Sedan()
    val car2 = Sedan()
    val car3 = Sedan()
    var sedanList = listOf(car1, car2, car3)
    sedanList = sedanList.customFilter{ it.filterByYear() }
    for (sedan in sedanList) {
        println("year: ($sedan)")
    }*/

    var list = (1..10).toList()
    val sum = list.customSum{ it % 2 == 1 }
    print(sum)


}

fun List<Int>.customSum(filterFunction: (Int) -> Boolean): Int {
    var result = 0
    for (item in this) {
        if (filterFunction(item))
            result+=item
    }
    return result
}

fun <T> List<T>.customFilter(filterFunction: (T) -> (Boolean)): List<T> {
    // custom implementation for lambda function (from scratch):
    // <T> is called generic type: for any type of object, customFilter function is applicable.
    // you can revise the explanaition of the fun definiton/parameter/return type: https://youtu.be/wnyN8umZIRM?t=555
    val resultList = mutableListOf<T>()
    for (item in this) {
        if(filterFunction((item))) {
            resultList.add(item)
        }
    }
    return resultList
}

fun lambdaFunctionExample () {

    //pre-definied lambda function example - provided by kotlin standard library
    val list = (1..10).toList()
    println(list)
    val filter = list.filter { it > 8 && it % 2 == 0 } // 'it' refers to each item on the list
    print(filter)

}

fun arithmetic() {
    /** 1. arithmetic manipulation & operations **/
    // a. Types
     val x: Int = 2      // ': Int' to explicitly specify the type
     val y = 20.23F      // 'F' stands for Float
     val z = 20.3145     // Double type is written without character declaration at the end of the value

    // b. Manipulation & Operations
     val pi = Math.PI
     val radius = 5.5
     val volume = 0.75 * pi * radius.pow(3.0) //radius.pow is a kotlin function. A replica of the OG function provided by Java Math library 'Math.pow'

     println("The volume of the sphere with radius $radius is $volume")
}

fun strings() {
    /** 2. [String] **/
     val name: String = "ali"
     println(name.reversed().uppercase())
     val palindrome = "racecar"
     if (palindrome == palindrome.reversed()) print("this is a palindrome") else print("this is not a palindrome")
}

fun ifConditions() {
    /** 3. [If-condition] **/
     val ifInsideValue = if(3>4) 0 else 1
     print("LOOK HERE! $ifInsideValue")

     val userInput = readlnOrNull()
     if (userInput == null) print("NULL VALUE") else print("The input you have entered is: $userInput")
     // tip: if you want to enter null value as a user input: Ctrl+D (Intellij specific)
}

fun arrays() {
    /** 4. [Arrays & Loops] **/
    val myArray = arrayOf(1, 2, 3, 43, 28)
    // For loop:
     for (i in myArray) print("$i, ")
     for (i in 10 downTo 0) print(i)
     for (i in 6 downTo  0 step 2) print(i) //skip two elements
    // While loop:
    var i=0
    while (i < myArray.size) {
        print("${myArray[i]}, ")
        i++
    }
    var maxItem = myArray[0]
    for (item in myArray) if (item>maxItem) maxItem=item
    println(maxItem)

    // HW1: enter number and decrease it down to zero
    println("Countdown to 0: ")
    val userInput = readlnOrNull()
    if (userInput!=null) {
        var decrementalValue = userInput.toInt()
        while (decrementalValue >= 0) {
            println(decrementalValue)
            decrementalValue--
        }
    }

    // HW2: pow of userInput numbers
    val firstNumber = readln()
    val secondNumber = readln()
    val result = firstNumber.toDouble().pow(secondNumber.toDouble())
    print("Result is: $result")
}

fun lists() {
    /** 5. [List]
    Lists are immutable (cannot be changed at run-time).
    The similarities & difference between lists and arrays:
    a. Array items can be modified at run-time, but immutable lists cannot.
    b. Both array and list cannot expand/shrink the size of the object

    However, to change a list from immutable 'listOf' to mutable one: 'mutableListOf'.
    That result in the ability to modify both of: item(s) of the list, and list size [i.e. mutableListOf.add()/remove().. etc].
     **/

    val emptyList = listOf<Int>()   //empty list must include the data type
    val list = listOf(1,2, 3)       //listOf should have the same data type
    val listTest = listOf(1,"he", 3)
    print(listTest)

    // difference between create array/list from userInput
    // 1. Array: cannot initialize it before userInput
    println("Enter items of an array: ")
    val first = readln()
    val second = readln()
    val third = readln()
    println("Items of the array are:")
    val arr = arrayOf(first,second,third)
    print(arr.joinToString(", "))

    // 2. List: can be initialized before userInput
    val userList = mutableListOf<Int>()
    for (i in 1..5) {
        val x = readlnOrNull()?.toInt()
        if (x!=null) userList.add(x)
    }
    print(userList)

    // [HOMEWORK!]
    val fibonacciList = mutableListOf(0,1)
    println("Enter a number n > 1 :")
    val userInput = readlnOrNull()?.toInt()
    if (userInput != null && userInput > 1) {
                var temp = fibonacciList[0]
                fibonacciList.add(temp)
    } // to be continued.. :)
}

fun whenKeyword() {
    /** 6. [When] keyword
     * 'when' keyword is used when we depend on [one] variable inside if-else(s) statement.
     * For example: each age range will have different message (1..5-> young) (5..20->kid ;p) **/

    val age = try {
        readlnOrNull()?.toInt()
    } catch (e: NumberFormatException) {
        0
    } finally {
        print("This will be printed anyway (finally block)")
    }
    val x = 5
    when (age) {
        in 1..5 -> print("Hey, kid :)")
        in 6..17 -> print("Enjoy life, even when you get older")
        18 -> print("welcome to adulthood!")
        19, 20 -> print("...")
        in 21..65 -> print("you're becoming old")
        66 -> if (x>1) print("test two variables in 'when' window")
        else -> print("Wisdom phase of life")
    }
}

fun sumOfValues(input: Int) {

    //Homework - Part 16 (functions and parameters)
    var result = 0
    print("The sum of the values from 1 to $input is: ")
    for (i in 1..input) result+=i
    print(result)

}

fun largestItem(input: List<Int>): Int {
    // the purpose of this function is to practice functions with return value.
    // To return a value of specific type, write ": Int/Double..etc" after function parameter.
    var largestItem = 0
    for (i in 0 .. input.size-2) {
        largestItem = if(input[i]>input[i+1]) input[i]
        else input[i+1]
    }
    return largestItem
}

fun multiply(a: Int, b: Int) = a * b  // Kotlin recognize that 'a' and 'b' are integers. Therefore, the return value will be integer without declaration.

fun searchIndex(list: List<Int>, userInput: Int): Int {
    // Functions with named parameters 'list' & 'userInput' does not need to be called in the right order.
    // For example: searchIndex(myList, 1) is the same as searchIndex(1, myList).
    return list.indexOf(userInput)
}

fun List<Int>.productOfListItems(): Int {
    /** the aim of this function is the following:
     * 1. Practice Extension Functions i.e. <DataType>.functionName()
     * 2. Solve Homework of part19 video (Kotlin newbie->pro series by Philip): Calculate the product of all items in a list.
     */
    var productResult = 1
    // 'this' keyword refers to the input of the user and needed to access that input, since the function have no parameters.
    for (i in this) productResult*=i
    return productResult
}