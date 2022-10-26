package com.example.quizv2.shared

import androidx.lifecycle.ViewModel

data class Question(var answers : MutableList<Pair<String,Boolean>>, val text : String)

class MyViewModel : ViewModel() {
    companion object {
        var questions: MutableList<Question> = mutableListOf()
        var questionCounter : Int = 0
    }

    fun startQuiz() {
        questions = mutableListOf()
        questionCounter = 0

        var question1 = Question(mutableListOf(Pair("answer1",false),Pair("answer2",false),Pair(" answer3",false),Pair("answer4",true)), " Question1")
        var question2 = Question(mutableListOf(Pair("answer1",false),Pair(" answer2",false),Pair(" answer3",true),Pair("answer4",false)), "Question2")
        var question3 = Question(mutableListOf(Pair("answer1",false),Pair("answer2",false),Pair("answer3",false),Pair("answer4",true)), " QUuestion3")
        var question4 = Question(mutableListOf(Pair("answer1",false),Pair("answer2",false),Pair("answer3",true),Pair("answer4",false)), " Question4")
        var question5 = Question(mutableListOf(Pair("answer1",false),Pair("answer2",false),Pair("answer3",true),Pair("answer4",false)), "Question5")

        questions.add(question1)
        questions.add(question2)
        questions.add(question3)
        questions.add(question4)
        questions.add(question5)
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