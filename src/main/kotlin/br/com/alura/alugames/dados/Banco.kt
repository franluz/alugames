package br.com.alura.alugames.dados

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

}