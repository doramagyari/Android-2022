package com.example.quizv2.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.quizv2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizStartFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizStartFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz_start, container, false)
        if( view != null){
            initViewItems(view)
        }
        return view
    }

    private fun initViewItems(view: View){
        startButton = view.findViewById(R.id.button)
    }

    private fun registerListeners(view: View){
        startButton.setOnClickListener {
            //cal Question
            //findNavController().navigate(R.id.action_quizStartFragment_to_questionFragment)
        }
    }


}