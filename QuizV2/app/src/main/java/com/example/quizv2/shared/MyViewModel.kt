package com.example.quizv2.shared

import androidx.lifecycle.ViewModel
import java.io.File


data class Question(var answers : MutableList<Pair<String,Boolean>>, val text : String)

class MyViewModel : ViewModel() {
    companion object {
        var questions: MutableList<Question> = mutableListOf()
        var questionCounter : Int = 0
    }

    var companion = Companion

    fun startQuiz() {
        questions = mutableListOf()
        questionCounter = 0

        var question1 = Question(mutableListOf(Pair("Adobe",false),Pair("Microsoft",false),Pair(" Google",false),Pair("JetBrains",true)), " Kotlin is developed by?")
        var question2 = Question(mutableListOf(Pair("Light",false),Pair(" Sealed Class",false),Pair(" Elvis Operator",true),Pair("Range",false)), "Which of following is used to handle null exceptions in Kotlin?")
        var question3 = Question(mutableListOf(Pair(".java",false),Pair(".kot",false),Pair(".andriod",false),Pair(".kt or .kts",true)), " Which file extension is used to save Kotlin files.")
        var question4 = Question(mutableListOf(Pair("abstract",false),Pair("sealed",false),Pair("final",true),Pair("public",false)), " All classes in Kotlin classes are by default?")
        var question5 = Question(mutableListOf(Pair("enum class Color {RED, GREEN, BLUE}",false),Pair("val set = hashSetOf(1, 2, 3)",false),Pair("val list = arrayListOf(1, 2, 3)",true),Pair("val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")",false)), "What is correct way to create an arraylist in Kotlin?")
        var question6 = Question(mutableListOf(Pair("A variable used for string interpolation",false),Pair("None of the above",false),Pair("A variable that cannot change, read-only",false),Pair("A variable that can be changed",true)), " What is an immutable variable?")
        var question7 = Question(mutableListOf(Pair("length(str)",false),Pair("str.length",true),Pair("Table",false),Pair("str.lengthOf",false)), " How do you get the length of a string in Kotlin?")
        var question8 = Question(mutableListOf(Pair("Primary constructor",false),Pair("Both 1 & 2",true),Pair("Secondary constructor",false),Pair("None of the above",false)), " Which of the followings constructors are available in Kotlin?")
        questions.add(question1)
        questions.add(question2)
        questions.add(question3)
        questions.add(question4)
        questions.add(question5)
        questions.add(question6)
        questions.add(question7)
        questions.add(question8)

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

    fun randomizeAnswers(){
        for(q in questions)
            q.answers.shuffle()
    }

    fun randomizeQuestions(){
        questions.shuffle()
        randomizeAnswers()
    }

    fun getQuestion() : Question{
        val question = Question(questions[questionCounter].answers, questions[questionCounter].text)
        questionCounter++
        return question
    }

}