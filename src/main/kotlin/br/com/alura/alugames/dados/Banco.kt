package br.com.alura.alugames.dados

import org.example.br.com.alura.alugames.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    // código omitido

    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "lsm979FRAN!!")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getJogos(): List<Jogo> {
        val jogos = mutableListOf<Jogo>()
        val conexao = obterConexao()
        if (conexao != null) {
            try {
                val statemant = conexao.createStatement()
                val resultado = statemant.executeQuery("SELECT * FROM jogos")
                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")
                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    jogos.add(jogo)
                }
                statemant.close()
            } finally {
                conexao.close()
            }
        }
        return jogos
    }

}