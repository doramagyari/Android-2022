import java.util.*

fun main(args: Array<String>) {

    //1.feladat
    testingbasics()
    //2.feladat
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday")
    for(i in daysOfWeek) {
        print("$i ")
    }
    println()

    daysOfWeek.forEach {print("$it ")}
    println()

    println("Days starting with T:")
    daysOfWeek.filter { it.startsWith("T")}.forEach{print("$it ")}
    println()

    println("Days containing the letter 'e':")
    daysOfWeek.filter { it.contains("e")}.forEach{print("$it ")}
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