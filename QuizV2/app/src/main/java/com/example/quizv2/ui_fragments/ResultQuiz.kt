package com.example.quizv2.ui_fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizv2.R
import com.example.quizv2.shared.MyViewModel
import kotlin.math.roundToInt

class ResultQuiz : Fragment() {

    val sharedView : MyViewModel by activityViewModels()


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result_quiz, container, false)

        //back button
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val dialogClickListener =
                    DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                findNavController().navigate(R.id.action_resultQuiz_to_startQuiz)
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

        val tryAgainButton = view.findViewById<Button>(R.id.tryAgainButton)
        tryAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultQuiz_to_startQuiz)
        }

        if(sharedView.companion.points*5%5 == 0F) {
            val points : Int = sharedView.companion.points.roundToInt()
            view.findViewById<TextView>(R.id.resultTextView).setText("$points / ${sharedView.companion.finalPoints}")
        }
        else{
            view.findViewById<TextView>(R.id.resultTextView).setText("${sharedView.companion.points} / ${sharedView.companion.finalPoints}")
        }

        return view
    }

}