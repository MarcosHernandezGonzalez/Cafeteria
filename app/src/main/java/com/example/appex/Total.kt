package com.example.appex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.appex.databinding.FragmentTotalBinding

class Total : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentTotalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTotalBinding.inflate(inflater)
        val platoCantidad = binding.platoCantidad
        platoCantidad.text = viewModel.cantidadPlato.value?.toInt().toString()
        val bebidaCantidad = binding.bebidaCantidad
        bebidaCantidad.text = viewModel.cantidadBebida.value?.toInt().toString()
        val platoTotalPrecio = binding.platoTotalPrecio
        platoTotalPrecio.text = viewModel.calcularTotalPlato().toString() + "€"
        val bebidaTotalPrecio = binding.bebidaTotalPrecio
        bebidaTotalPrecio.text = viewModel.calcularTotalBebida().toString() + "€"
        val preuTotal = binding.preuTotal
        preuTotal.text = viewModel.calcularTotal().toString() + "€"
        return binding.root
    }

}