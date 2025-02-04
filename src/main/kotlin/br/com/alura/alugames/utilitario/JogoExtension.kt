package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.JogoEntity
import org.example.br.com.alura.alugames.modelo.Jogo

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao,
        this.Id
    )
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao,
        this.Id
    )
}