package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int,
    val percentualDescontoReputacao: Double,
     id: Int=0
) : Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        var totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1
        return if (totalJogosNoMes <= jogosInclusos) {
            0.0
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }

    }
}

