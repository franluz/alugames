package org.example.br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.servicos.ConsumoApi
import org.example.br.com.alura.alugames.modelo.Jogo
import transformarEmIdade
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do gamer: " + gamer)
    println("Idade do Gamer: "+gamer.dataNascimento?.transformarEmIdade())
    do {
        println("Digite o numero do jogo")
        val busca = leitura.nextLine()
        val buscaApi = ConsumoApi()
        var meuJogo: Jogo? = null
        val informacaoJogo = buscaApi.buscaJogo(busca)

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
        resultado.onFailure {
            println("Jogo nao existe, tente outro")
        }
        resultado.onSuccess {
            println("Deseja inserir uma descricao personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", ignoreCase = true)) {
                println("Insira a descricao personalida para o Jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
        }
        gamer.jogosBuscados.add(meuJogo)
        println("Deseja buscar novo jogo? S/N")
        val resposta = leitura.nextLine()
    } while (resposta.equals("s", true))
    println("Jogos buscados")
    println(gamer.jogosBuscados)
    println("Jogos ordenados por titulo:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    gamer.jogosBuscados.forEach {
        println("Titulo:" + it?.titulo)
    }
    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("Batman", true) ?: false
    }
    println("\n Jogos filtrados")
    println(jogosFiltrados)
    println("Deseja excluir algum jogo da lista Original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println("Qual posicao voce deseja excluir? Posicoes preenchidas " + gamer.jogosBuscados.size)

        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
        println(gamer.jogosBuscados)
    }

    println("Busca realizada com sucesso!!")

}