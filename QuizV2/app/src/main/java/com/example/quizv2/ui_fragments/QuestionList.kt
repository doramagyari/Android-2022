package com.example.quizv2.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizv2.OnQuestionClickListener
import com.example.quizv2.R
import com.example.quizv2.RecyclerViewAdapter
import com.example.quizv2.databinding.FragmentQuestionListBinding
import com.example.quizv2.shared.MyViewModel
import com.example.quizv2.shared.Question


class QuestionList : Fragment() {

    val sharedView : MyViewModel by activityViewModels()
    lateinit var binding: FragmentQuestionListBinding
    private lateinit var mQuestionListAdapter: RecyclerViewAdapter

    private val mOnQuestionClickListener = object : OnQuestionClickListener {

        override fun onDelete(model: Question) {
            //remove item from list
            mQuestionListAdapter.removeProduct(model)
        }
        override fun onDetails(model: Question) {
            val fragmentTransaction = parentFragmentManager.beginTransaction()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionList = sharedView.questions

        val recycler_view = view.findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        mQuestionListAdapter = RecyclerViewAdapter(questionList,mOnQuestionClickListener)
        recycler_view.adapter = mQuestionListAdapter
    }

}
