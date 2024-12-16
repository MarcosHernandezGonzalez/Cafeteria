package com.example.appex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appex.databinding.FragmentPlato1Binding

class Plato1 : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentPlato1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlato1Binding.inflate(inflater)
        val button = binding.button
        val precio = binding.textView3
        precio.text = viewModel.precioPlato.toString()
        button.setOnClickListener {
            val cantidad = binding.etNumberInput
            viewModel.setCantidadPlato(cantidad.text.toString().toInt())
            findNavController().navigate(R.id.action_plato1_to_bebida)
        }
        return binding.root
    }

}
