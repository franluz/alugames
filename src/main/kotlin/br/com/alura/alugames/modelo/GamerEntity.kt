package br.com.alura.alugames.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table
@Entity
@Table(name = "gamer")
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var Id: Int = 0,
    val nome: String = "Jogador",
    val email: String = "email@testea.com",
    var dataNascimento: String? = null,
    var usuario: String? = null,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()

) {

}