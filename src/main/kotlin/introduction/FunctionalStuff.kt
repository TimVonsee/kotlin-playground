package introduction

// function composition
typealias Func<A, B> = (A) -> B

val sayHello : Func<String, String> = {  "Hello, $it" }
val addExcitement : Func<String, String> = { text -> "$text!"}

infix fun <A, B, C> Func<B, C>.after(f: Func<A, B>): Func<A, C> = { x: A -> this(f(x)) }

fun main() {
    println((addExcitement after sayHello)("Tim"))


}