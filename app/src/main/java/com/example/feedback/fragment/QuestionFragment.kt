package com.example.feedback.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.feedback.R
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        // Handle 5 selection buttons and 1 back button
        selection_1.setOnClickListener(this)
        selection_2.setOnClickListener(this)
        selection_3.setOnClickListener(this)
        selection_4.setOnClickListener(this)
        selection_5.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    // Implement OnClick method
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.selection_1 -> {navigateWithIndex(1)}
            R.id.selection_2 -> {navigateWithIndex(2)}
            R.id.selection_3 -> {navigateWithIndex(3)}
            R.id.selection_4 -> {navigateWithIndex(4)}
            R.id.selection_5 -> {navigateWithIndex(5)}
            R.id.btn_back -> { navController.popBackStack()}
        }
    }

    // Handle Selection with Index
    private fun navigateWithIndex(index: Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_questionFragment_to_resultFragment, bundle)
    }
}