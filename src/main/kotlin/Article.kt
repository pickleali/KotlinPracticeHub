/** the aim of this class is to practice the following:
 * 1. create class and its constructor(s)/functions
 * 2. implement nested function for readability purposes
 * 3. revise multiple learning outcomes:
 *      when keyword, kotlin libraries, dealing with lists, and manipulate data for certain purpose.
 * 4. Practice 'vararg': To pass a variable number of arguments to a function [instead of a,b,c,d..etc. One argument is enough]
 **/

// To inherit a superclass, write the name of superclass after the parentheses of subclass.
// Also, it is required to identify the superclass as an 'open class'.
// Example: class Article(a, b, c) : Website()
//          open class website()
// Abstract class: instead of writing 'open' before class, write 'abstract' keyword in order to make it an abstract.
//                 The purpose of abstract class is to initialize a function for all classes and each class has its own definition.
//                 Example: area() definition for rectangle is different from triangle.
// As for visibility modifiers (public,private..etc),
// check kotlin.org docs for clear demonstration: https://kotlinlang.org/docs/visibility-modifiers.html#class-members

class Article(
    // to make constructor of a class private,
    // write: class Article(...) private constructor {...}

    private val website: String,
    private val topic: String,
    private val tag: String? = null
) {

    private fun shuffleListItems(vararg input: Int): Int {
        val shuffleIndex = kotlin.random.Random.nextInt(from = 0, until = input.size-1)
        return input[shuffleIndex]
    }

    fun articleOfTheDay() {
        if(tag!=null) println("Good morning!\nThe recommended ($topic) article from $website.com/#$tag: ")
        else println("Good morning!\nThe recommended ($topic) article from $website.com: ")
        val items = shuffleListItems(1, 2, 3, 4, 5)
        when(items) {
            1 -> print("Node.js fundamentals")
            2 -> print("KMM structure explained")
            3 -> print("The age of Agile must end. By: Michael Burnett")
            4 -> print("1 Million People Can’t Be Wrong: New Bing Is Taking Over Search. By: Liquid Ocelot")
            5 -> print("The Simpsons: A Visionary Look into the Future of UX Design. By: Dinah Manongi")
        }
    }
}