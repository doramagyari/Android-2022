package com.example.quizv2.ui_fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizv2.R
import com.example.quizv2.shared.MyViewModel

class CurrentQuiz : Fragment() {
    val sharedView : MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_current_quiz, container, false)

        //back button
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val dialogClickListener =
                    DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                findNavController().navigate(R.id.action_currentQuiz_to_startQuiz)
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {

                            }
                        }
                    }

                val builder = AlertDialog.Builder(context)
                builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show()

            }
        })

        var question = sharedView.getQuestion()

        val questionText = view.findViewById<TextView>(R.id.questionText)
        questionText.setText(question.text)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        for (i in 0 until radioGroup.childCount) {
            (radioGroup.getChildAt(i) as RadioButton).text = question.answers[i].first
        }

        val nextButton = view.findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {

            if(oneAnswerChecked()){
                var number : MutableList<Int> = mutableListOf()
                for (i in 0 until radioGroup.childCount) {
                    if((radioGroup.getChildAt(i) as RadioButton).isChecked)
                        number.add(i)
                }
                    if(sharedView.typeOfNewxtQuestion() == 1) {
                        findNavController().navigate(R.id.action_currentQuiz_self)
                    }
                    else{
                        findNavController().navigate(R.id.action_currentQuiz_to_currentQuizCheck)
                    }
            }
        }

        return view
    }


    private fun oneAnswerChecked() : Boolean{
        val radioGroup = view?.findViewById<RadioGroup>(R.id.radioGroup)
        if (radioGroup != null) {
            for (i in 0 until radioGroup.childCount) {
                if((radioGroup.getChildAt(i) as RadioButton).isChecked)
                    return true
            }
        }
        return false
    }

}
