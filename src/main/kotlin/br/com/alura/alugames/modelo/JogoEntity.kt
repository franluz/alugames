package br.com.alura.alugames.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String = "Titulo do Jogo",
    val capa: String = "Capa do jogo",
    val preco: Double = 0.0,
    var descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var Id: Int = 0
) {
}