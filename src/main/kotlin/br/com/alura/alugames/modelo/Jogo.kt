package org.example.br.com.alura.alugames.modelo

import br.com.alura.alugames.modelo.Recomendavel
import com.google.gson.annotations.Expose

data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String,
    var Id: Int = 0

) : Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    var notas: MutableList<Int> = mutableListOf<Int>()
    override val media: Double
        get() = notas.average()

    override fun toString(): String {
        return "\n Jogo(" +
                " Id= $Id" +
                "\n Titulo:'$titulo'," +
                "\n Capa:'$capa'," +
                "\n Descricao:'$descricao'" +
                "\n Preco: $preco," +
                "\n Media: $media)"
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String,
        Id: Int = 0
    ) : this(titulo, capa, Id) {
        this.preco = preco
        this.descricao = descricao
    }


    override fun recomendar(valor: Int) {
        notas.add(valor)
    }
}