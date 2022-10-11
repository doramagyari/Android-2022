fun main() {
    val itemController = ItemController(ItemService(ItemRepository()))
    println("How many questions do you want to take? (Maximum is 10! )")
    val nrOfQ = readLine()!!.trim().toInt()
    if (nrOfQ <= 0 || nrOfQ > 10 ) println("Incorrect quantity! Good Bye!") else itemController.quiz(nrOfQ)

}