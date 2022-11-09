package com.example.quizv2.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.quizv2.R
import com.example.quizv2.databinding.FragmentResultQuizBinding
import com.example.quizv2.shared.MyViewModel
import com.example.quizv2.ui_fragments.StartQuiz
import kotlin.math.roundToInt

class ResultQuiz : Fragment() {

    val sharedView : MyViewModel by activityViewModels()
    lateinit var binding : FragmentResultQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultQuizBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tryAgainButton.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, StartQuiz())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        if(sharedView.points*10%10 == 0F) {
            val points : Int = sharedView.points.roundToInt()
            binding.resultTextView.text = "$points / ${sharedView.finalPoints}"
            sharedView.latestScore = points.toString().toFloat()
        }
        else{
            binding.resultTextView.text = "${sharedView.points} / ${sharedView.finalPoints}"
            sharedView.latestScore = sharedView.points.toString().toFloat()
        }




    }

}