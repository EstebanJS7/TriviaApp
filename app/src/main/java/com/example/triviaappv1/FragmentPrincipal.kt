package com.example.triviaappv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
class FragmentPrincipal : Fragment(R.layout.fragment_principal){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPlay = requireView().findViewById<Button>(R.id.btnPlay)

        btnPlay.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentPrincipal5_to_fragmentQuestions2)
        }
    }
}