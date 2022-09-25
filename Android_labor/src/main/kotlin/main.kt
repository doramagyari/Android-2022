import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {

    //1.feladat
    testingbasics()
    //2.feladat -list,filter
    val daysOfWeek = listOf("Monday", "Tuesday", "wednesday", "saturday")
    for (i in daysOfWeek) {
        print("$i ")
    }
    println()

    daysOfWeek.forEach { print("$it ") }
    println()

    println("Days starting with T:")
    daysOfWeek.filter { it.startsWith("T") }.forEach { print("$it ") }
    println()

    println("Days containing the letter 'e':")
    daysOfWeek.filter { it.contains("e") }.forEach { print("$it ") }
    println()

    //3.fealadt

    range(57);
    println()

    //4.feladat

    println("Message coding:")
    val message = messageCoding("Kotlin", ::encode)
    println("Coded message: $message")
    print("Decoded message:")
    println(messageCoding(message, ::decode))

    //5.feladat -compact function

    println(evenNum(num = 2));

    //6.feladat - map

    //a
    val numbers = setOf(1, 2, 3)
    println(numbers)
    println(numbers.map { it * 2 })

    //b
    val uppercase = daysOfWeek.map { it.toUpperCase() }
    println(uppercase)

    //c
    val uppercase1 = daysOfWeek.map { it.toUpperCase() }
    println(uppercase1.associateBy { it.first().toUpperCase() })

    //d
    val size = daysOfWeek.map { it.length }
    println(size)

    //7 -mutable lists

    //a
    val days = mutableListOf<String>("Monday", "Tuesday", "wednesday", "saturday");
    days.remove(days.contains("n"))
    for (i in days) {
        println("$i ")
    }

    //b
    for ((index, value) in days.withIndex()) {
        println("Item at $index is $value")
    }

    //c
    val day = mutableListOf("Monday", "Tuesday","Aaa", "wednesday", "saturday")
    day.sort()
    println(day)

    //8 -arrays

    //a
    val array = Array(10) { Random.nextInt(0, 100)}
    array.forEach { println(it) }

    //b
    array.sort()
    for (i in array) {
        println("$i  ")
    }

    //c
    /*for (i in array) {
        if (array[i] % 2 == 0)
            println("$array[i] is even")
        else
            println("$array[i] is odd")
    }*/

    //d
    val sumArr = array.sum()
    println("Sum Array : $sumArr")
    val avgArr = sumArr/10
    println("Avg Array: $avgArr")
}


fun testingbasics() {
    println("Hello World!")

    val name : String = "Magyari Dora"
    //name = "Magyari Dora"

    val number1 = 2
    val number2 = 5
    println("$number1 + $number2 = ${number1 + number2}")
}

fun range(num :Int) {
//    for(i in 1..100){
//        if(isPrime(i))
//            println(i)
//    }
    (2..num).filter { isPrime(it) }.forEach {print("$it ")}
}

fun isPrime(num : Int) : Boolean{
    var cr = 0
    for(i in 1..num){
        if(num % i == 0) cr++
    }

    if(cr == 2) return true
    return false
}

fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg)
}

fun encode(msg: String): String {
    //return msg.encodeToByteArray()
    return Base64.getEncoder().encodeToString(msg.toByteArray())
}

fun decode(msg: String): String{
//    return msg.decodeToString()
    val decoder = Base64.getDecoder()
    val decoded = String(decoder.decode(msg))
    return decoded
}

fun evenNum(num : Int) = listOf(10, 22, 32, 4, 5)
    .filter{ num -> num % 2 == 0
    }

