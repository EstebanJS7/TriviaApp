package com.example.triviaappv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.triviaappv1.databinding.FragmentQuestionsBinding
import java.util.*

class FragmentQuestions : Fragment(R.layout.fragment_questions) {

    private val preguntasConFechas = arrayOf(
        arrayOf(
            "¿En qué año se fundó la ciudad de Roma?",
            "21 de abril del 753 a.C.",
            "27 de agosto del 712 a.C."
        ),
        arrayOf(
            "¿Cuándo comenzó la Primera Guerra Mundial?",
            "28 de julio de 1914",
            "4 de agosto de 1914"
        ),
        arrayOf(
            "¿Cuándo ocurrió el descubrimiento de América?",
            "12 de octubre de 1492",
            "1 de enero de 1493"
        ),
        arrayOf(
            "¿En qué año se publicó la obra 'Don Quijote de la Mancha'?",
            "16 de enero de 1605",
            "4 de mayo de 1601"
        ),
        arrayOf(
            "¿Cuándo se proclamó la Declaración de Independencia de los Estados Unidos?",
            "4 de julio de 1776",
            "2 de septiembre de 1783"
        )
    )

    private lateinit var binding: FragmentQuestionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentQuestionsBinding.bind(view)

        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val tvQuestions = binding.tvQuestioArray

        val randomIndex = Random().nextInt(preguntasConFechas.size)
        val pregunta = preguntasConFechas[randomIndex][0]
        val fechaCorrecta = preguntasConFechas[randomIndex][1]
        val fechaIncorrecta = preguntasConFechas[randomIndex][2]

        if (Random().nextBoolean()) {
            btn1.text = fechaCorrecta
            btn2.text = fechaIncorrecta
        } else {
            btn1.text = fechaIncorrecta
            btn2.text = fechaCorrecta
        }

        tvQuestions.text = pregunta

        btn1.setOnClickListener { onOptionSelected(btn1.text == fechaCorrecta) }
        btn2.setOnClickListener { onOptionSelected(btn2.text == fechaCorrecta) }
    }

    private fun onOptionSelected(isAnswerCorrect: Boolean) {
        val bundle = Bundle().apply {
            putBoolean("isAnswerCorrect", isAnswerCorrect)
        }
        findNavController().navigate(R.id.action_fragmentQuestions2_to_fragmentResults2, bundle)
    }
}

