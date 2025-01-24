package br.com.alura.alugames.modelo

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "gamer")
class GamerEntity(
    val nome: String = "Jogador",
    val email: String = "email@testea.com",

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var Id: Int = 0
) {

    var dataNascimento: String? = null
    var usuario: String? = null
}