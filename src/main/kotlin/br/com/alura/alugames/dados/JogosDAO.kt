package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.JogoEntity
import org.example.br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo>(manager) {

    override fun getLista(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity ->
            Jogo(
                entity.titulo,
                entity.capa, entity.preco,
                entity.descricao, entity.Id
            )
        }

    }

    override fun toEntity(model: Jogo) {
        return JogoEntity(
            model.titulo,
            model.capa,
            model.preco,
            model.descricao,
            model.Id
        )

    }

}