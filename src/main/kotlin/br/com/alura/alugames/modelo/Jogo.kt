package org.example.br.com.alura.alugames.modelo

data class Jogo(val titulo: String, val capa: String) {
    var descricao:String? = null
    override fun toString(): String {
        return "Jogo(Titulo:'$titulo'," +
                " Capa:'$capa'," +
                " Descricao:'$descricao')"
    }


}