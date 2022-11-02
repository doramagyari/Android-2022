package com.example.quizv2.ui_fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import android.content.DialogInterface
import com.example.quizv2.R
import com.example.quizv2.shared.MyViewModel


class CurrentQuizRadiobutton : Fragment() {

    val sharedView : MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
        for (i in 0 until radioGroup.childCount) { //valaszok megjelenitese
            (radioGroup.getChildAt(i) as RadioButton).text = question.answers[i].first
        }


        val nextButton = view.findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {

            if (oneAnswerChecked()) { //ha kijelolok egy valaszt --ellenorzes hogy helyes-e
                var number: MutableList<Int> = mutableListOf()
                for (i in 0 until radioGroup.childCount) {
                    if ((radioGroup.getChildAt(i) as RadioButton).isChecked)
                        number.add(i)
                }
                sharedView.calculateResult(question, number)
                if (sharedView.endOfQuiz())
                    findNavController().navigate(R.id.action_currentQuiz_to_resultQuiz) //ha a quiz veget ert kiirja az eredmenyt
                else {
                    if (sharedView.typeOfNewxtQuestion() == 1) {
                        findNavController().navigate(R.id.action_currentQuiz_self) //ha tovabblepek marad maga a quiz a kovetkezo kerdessel
                    }

                }
            }
        }


        return view
    }


    private fun oneAnswerChecked() : Boolean{ //ha kijeloltem egy helyes valaszt megjeleniti a kovetkezo kerdest a valaszokkal egyutt
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