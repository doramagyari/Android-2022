fun main() {
    val itemController = ItemController(ItemService(ItemRepository()))
    println("Number of questions you want to take?")
    val numOfQ = readLine()!!.trim().toInt()
    if (numOfQ <= 0 || numOfQ > 10 ) println("Incorrect") else itemController.quiz(numOfQ)

}