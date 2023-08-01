package com.example.triviaappv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.triviaappv1.databinding.FragmentResultsBinding
import androidx.navigation.fragment.findNavController
import androidx.core.content.ContextCompat

class FragmentResults : Fragment(R.layout.fragment_results) {

    private lateinit var binding: FragmentResultsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResultsBinding.bind(view)

        val tvResults = binding.tvResults
        val btnResults = binding.btnResults

        // Obtener el valor del argumento isAnswerCorrect
        val isAnswerCorrect = arguments?.getBoolean("isAnswerCorrect")

        // Verificar si el argumento no es nulo antes de usarlo
        if (isAnswerCorrect != null) {
            if (isAnswerCorrect) {
                // Respuesta correcta
                tvResults.text = "¡Correcto!"
                // Cambiar el fondo a rojo
                view.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_light))
            } else {
                // Respuesta incorrecta
                tvResults.text = "Incorrecto :("
                // Cambiar el fondo a azul
                view.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.holo_blue_light))
            }
        }

        btnResults.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResults2_to_fragmentQuestions2)
        }
    }
}


