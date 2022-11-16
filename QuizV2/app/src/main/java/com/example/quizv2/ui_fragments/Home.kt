package com.example.quizv2.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.quizv2.R
import com.example.quizv2.databinding.FragmentHomeBinding


class Home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var testSkills : Button
    lateinit var readQuestions : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        testSkills = binding.homeButton1
        readQuestions  = binding.homeButton2
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testSkills.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, StartQuiz()).addToBackStack(null).commit()
        }

        readQuestions.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, QuestionList()).addToBackStack(null).commit()
        }

    }
}