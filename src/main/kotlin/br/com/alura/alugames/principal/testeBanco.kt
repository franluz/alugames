package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import org.example.br.com.alura.alugames.modelo.Jogo

fun main() {
    val jogos: List<Jogo> = Banco.getJogos()
    println(jogos)
}