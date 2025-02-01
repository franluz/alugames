package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.GamerEntity
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(model: Gamer): GamerEntity {
        return GamerEntity(
            model.Id,
            model.nome,
            model.email,
            model.dataNascimento,
            model.usuario,
            model.plano.toEntity()
        )
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            entity.nome,
            entity.email,
            entity.Id
        ).apply { plano = entity.plano.toModel() }
    }
}