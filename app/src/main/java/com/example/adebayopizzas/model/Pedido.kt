package com.example.adebayopizzas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Pedido {
    @Parcelize
    data class Pedido(
        val nomeCliente: String,
        val sabores: List<String>,
        val tamanho: String,
        val tipoPagamento: String
    ) : Parcelable

}