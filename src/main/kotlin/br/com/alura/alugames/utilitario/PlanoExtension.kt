package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.*

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(
            this.tipo,
            this.mensalidade,
            this.jogosInclusos,
            this.percentualDescontoReputacao,
            this.id
        )
    } else {
        PlanoAvulsoEntity(
            this.tipo,
            this.id
        )
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(
            this.tipo,
            this.mensalidade,
            this.jogosIncluidos,
            this.percentualDescontoReputacao,
            this.id
        )
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}