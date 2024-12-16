package com.example.appex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    // LiveData para los precios de plato y bebida
    private val _precioPlato = 10.0
    val precioPlato: Double get() = _precioPlato

    private val _precioBebida = 4.0
    val precioBebida: Double get() = _precioBebida

    private val _cantidadPlato = MutableLiveData<Double>()
    val cantidadPlato: LiveData<Double> get() = _cantidadPlato

    private val _cantidadBebida = MutableLiveData<Double>()
    val cantidadBebida: LiveData<Double> get() = _cantidadBebida

    private val _precioTotal = MutableLiveData<Double>()
    val precioTotal: LiveData<Double> get() = _precioTotal



    fun setCantidadPlato(cantidad: Int){
        _cantidadPlato.value = cantidad.toDouble()
    }

    fun setCantidadBebida(cantidad: Int){
        _cantidadBebida.value = cantidad.toDouble()
    }

    fun calcularTotalPlato(): Double{
        return (_precioPlato * cantidadPlato.value!!)
    }

    fun calcularTotalBebida(): Double{
        return (_precioBebida * cantidadBebida.value!!)
    }
    fun calcularTotal(): Double{
        val total = (_precioPlato * cantidadPlato.value!!) + (_precioBebida * cantidadBebida.value!!)
        _precioTotal.value = total
        return total
    }

}