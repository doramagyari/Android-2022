package com.example.quizv2.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quizv2.databinding.FragmentProfileBinding
import com.example.quizv2.shared.MyViewModel


class Profile : Fragment() {

    val sharedView : MyViewModel by activityViewModels()
    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(sharedView.playerName != "" && sharedView.latestScore != 0F){
            binding.playerName.text = sharedView.playerName
            binding.highScore.text = sharedView.latestScore.toString()
        }
    }
}