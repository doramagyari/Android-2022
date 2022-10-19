package com.example.quizv2.model

data class Item(var question: String, var answers: MutableList<String>, var correct: Int) {
}