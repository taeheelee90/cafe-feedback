package com.example.feedback.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.feedback.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_result.*


/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    var selection = -1
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get selection number from QuestionFragment bundle
        selection = arguments?.getInt("index")?: -1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setResult(selection)

        // btn_close closes this activity
        btn_close.setOnClickListener {
            activity?.finish()
        }
    }

    // Set different result message per user selection
    fun setResult(selection : Int){
        when(selection){
            1 -> {
                result_contents.text = "We are happy to hear your feedback."
            }
            2 -> {
                result_contents.text = "We are happy to hear your feedback."
            }
            3-> {
                result_contents.text ="We hope to see you soon again. "
            }
            4 -> {
                result_contents.text="We will improve our services accordingly."
            }
            5 -> {
                result_contents.text="We will improve our services accordingly."
            }
        }
    }


}