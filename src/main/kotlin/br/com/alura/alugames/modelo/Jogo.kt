package org.example.br.com.alura.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) {
    var descricao: String? = null
    var preco = 0.0
    override fun toString(): String {
        return "Jogo(Titulo:'$titulo'," +
                " Capa:'$capa'," +
                " Descricao:'$descricao'" +
                " Preco: $preco)"
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String
    ) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

}