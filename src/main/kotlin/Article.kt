/** the aim of this class is to practice the following:
 * 1. create class and its constructor(s)/functions
 * 2. implement nested function for readability purposes
 * 3. revise multiple learning outcomes:
 *      when keyword, kotlin libraries, dealing with lists, and manipulate data for certain purpose.
 * 4. Practice 'vararg': To pass a variable number of arguments to a function [instead of a,b,c,d..etc. One argument is enough]
 **/

class Article(
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