package br.com.alura.alugames.principal

class Exorcismo {
    fun generate(phrase: String): String {
        var retornoAcronomo = ""
        if (!phrase.isNullOrEmpty()) {
            var acronomuns = phrase.split(" ", "-")
            var acron = acronomuns.map { it.trim().substring(0, 1) }.toString()
            retornoAcronomo = acron.toString().uppercase()
        }
        return retornoAcronomo
    }

    fun main() {
        println(generate("As Soon As Possible"))
    }


}