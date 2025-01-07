package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int
) :
    Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        var totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1
         return if (totalJogosNoMes <= jogosInclusos) {
            0.0
        }else{
             super.obterValor(aluguel)
        }

    }
}

