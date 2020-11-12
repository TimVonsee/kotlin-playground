package introduction

fun main(args: Array<String>){
    println("Hello, world!")

    // Challenge 1
    println(challenge1(listOf(3,6,5,4)))
    println(challenge1(listOf(40,40,40,60)))
    println(challenge1(listOf(201,101,101,200)))

    // Challenge 2
    println(challenge2(listOf(1,5,5,1,6,1)))

    // Challenge 3
    println(challenge3("WhoxxxxxxprefersxxxxxxxxJavaxx11xxxxxxxoverxxKotlin"))
}

fun challenge1 (numbers : List<Int>) : String{
    val sum : Int = numbers.max()!!
    val (a,b,c) = numbers.filter { it != sum }
    return "${sum-a} ${sum-b} ${sum-c}"
}

// had to look this one up, came up with a imperative solution.
// using a Set and new List to store
fun challenge2 (numbers: List<Int>) : String{
    return numbers
                .reversed()
                .distinct()
                .reversed()
                .joinToString (" ")
}

fun challenge3 (fileName : String) : Int {
    val regex = "x{3,}".toRegex()
    val matches = regex.findAll(fileName);
    return matches
                .map { it.value.length -  2}
                .sum()
}