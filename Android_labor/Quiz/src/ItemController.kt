class ItemController(private val itemService: ItemService) {

    fun quiz(nrOFQuestions : Int) {
        val questions = itemService.selectRandomItems(nrOFQuestions)
        var correctAnswers = 0
        questions.forEach { println(it.question)
            for (i in it.answers){
                println(i)
            }
            print("Chose your answer: ")
            val userAnswer = readLine()!!.trim().toInt()
            if(userAnswer==it.correct){
                correctAnswers++
                println("Correct!")
            }else{
                println("Incorrect!")
            }
        }
        println("You got $correctAnswers/$nrOFQuestions answers correct!")

    }

}