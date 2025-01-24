package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import org.example.br.com.alura.alugames.modelo.Jogo

fun main() {
    val jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo1 = Jogo(
        "The Last of Us Part IDANDARA",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val manager = Banco.getEntityManager()
    val jogosDao = JogosDAO(manager)
   // jogosDao.adicionar(jogo1)
    val jogoRecuperado = jogosDao.recuperarPeloId(3)
    println(jogoRecuperado)
    jogosDao.apagar(3)
    val jogos: List<Jogo> = jogosDao.getLista()

    println(jogos)
    manager.close()
}