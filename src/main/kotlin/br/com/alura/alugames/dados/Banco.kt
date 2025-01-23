package br.com.alura.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {
    // código omitido

    //    fun obterConexao(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "lsm979FRAN!!")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }
    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory =
            Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }


}