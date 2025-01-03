package br.com.alura.alugames.modelo

 class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int
) :
    Plano(tipo) {}
