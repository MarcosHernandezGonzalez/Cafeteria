package com.example.appex

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
import com.example.appex.databinding.FragmentBebidaBinding
import com.example.appex.databinding.FragmentPlato1Binding

class Bebida : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentBebidaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBebidaBinding.inflate(inflater)
        val button = binding.button
        val precio = binding.textView3
        precio.text = viewModel.precioBebida.toString()
        button.setOnClickListener {
            val cantidad = binding.etNumberInput
            viewModel.setCantidadBebida(cantidad.text.toString().toInt())
            findNavController().navigate(R.id.action_bebida_to_total)
        }
        return binding.root
    }
}
