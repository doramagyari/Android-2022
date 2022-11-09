package com.example.quizv2.shared

import androidx.lifecycle.ViewModel
import java.io.File


data class Question(var answers : MutableList<Pair<String,Boolean>>, val text : String)
val mineQuestions: MutableList<Question> = mutableListOf(
    Question(mutableListOf(Pair(" Google",false),Pair("Adobe",false),Pair("Microsoft",false),Pair("JetBrains",true)), " Kotlin is developed by?")
    ,Question(mutableListOf(Pair("Range",false),Pair(" Sealed Class\n",false),Pair(" Elvis Operator\n",true),Pair(" Lambda function\n",false)), "Which of following is used to handle null exceptions in Kotlin?")
    ,Question(mutableListOf(Pair(" .java\n",false),Pair(" .kot\n",false),Pair(" .andriod\n",false),Pair(" .kt or .kts\n",true)), "Which file extension is used to save Kotlin files.")
    ,Question(mutableListOf(Pair("abstract",false),Pair("sealed",false),Pair("final",true),Pair("public",false)), "All classes in Kotlin classes are by default?")
    ,Question(mutableListOf(Pair(" val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")\n",false),Pair(" enum class Color {RED, GREEN, BLUE}\n",false),Pair("val list = arrayListOf(1, 2, 3) ",true),Pair(" val set = hashSetOf(1, 2, 3)\n",false)), "What is correct way to create an arraylist in Kotlin?")
)

class MyViewModel : ViewModel() {
    var playerName : String = ""
    var latestScore = 0F

    var questions: MutableList<Question> = mineQuestions
    var questionCounter : Int = 0
    var points : Float = 0F
    var finalPoints : Int = 0

    fun startQuiz() {
        points = 0F
        finalPoints = 0
        questionCounter = 0


        randomizeQuestions()
    }

    fun typeOfNewxtQuestion() : Int{
        var counter = 0
        for(q in questions[questionCounter].answers){
            if(q.second == true){
                counter++
            }
        }
        return counter
    }

    fun randomizeQuestions(){
        questions.shuffle()
//        randomizeAnswers()
    }

//    fun randomizeAnswers(){
//        for(q in questions)
//            q.answers.shuffle()
//    }

    fun endOfQuiz() : Boolean {
        if (questionCounter == questions.size) {
            return true
        }
        return false
    }

    fun getQuestion() : Question{
        val question = Question(questions[questionCounter].answers, questions[questionCounter].text)
        questionCounter++
        return question
    }

    fun calculateResult(question: Question, numbers : MutableList<Int>) {
        finalPoints++

        var correctAnswers = 0F
        for(number in numbers)
            if(question.answers[number].second == true){
                correctAnswers++
            }

        var questionCorrectAnswer = 0
        for(q in question.answers){
            if(q.second == true)
                questionCorrectAnswer++
        }

        points += correctAnswers/questionCorrectAnswer
    }

}