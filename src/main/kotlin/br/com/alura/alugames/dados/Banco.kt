package br.com.alura.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Banco {
    // código omitido

    class Banco {
        fun obterConexao(): Connection? {
            return try {
                DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "aLxXzDcgueZu6z")
            } catch (e: SQLException) {
                e.printStackTrace()
                null
            }
        }
    }
}