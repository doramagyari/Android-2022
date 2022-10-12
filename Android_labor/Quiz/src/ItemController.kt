class ItemController(private val itemService: ItemService) {

    fun quiz(numQuestions : Int) {
        val questions = itemService.selectRandomItems(numQuestions)
        var correct = 0
        questions.forEach { println(it.question)
            for (i in it.answers){
                println(i)
            }
            print("Chose your answer: ")
            val userAnswer = readLine()!!.trim().toInt()
            if(userAnswer==it.correct){
                println("Correct!")
                correct++
            }else{
                println("Incorrect!")
            }
        }

    }

}