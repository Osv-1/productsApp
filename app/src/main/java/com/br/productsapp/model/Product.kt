package com.br.productsapp.model

import java.math.BigDecimal

data class Product(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
