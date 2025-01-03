package br.com.alura.alugames.modelo

import org.example.br.com.alura.alugames.modelo.Jogo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo

) {
    val valorAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "\n Aluguel do ${jogo.titulo} por ${gamer.nome}  pelo valor de $valorAluguel"
    }
}
