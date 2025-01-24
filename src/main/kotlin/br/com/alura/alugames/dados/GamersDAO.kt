package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.GamerEntity
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(model: Gamer): GamerEntity {
        return GamerEntity(
            model.nome,
            model.email

        )
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            entity.nome,
            entity.email,
            entity.Id
        )
    }
}