package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Aluguel
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager) : DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(model: Aluguel): AluguelEntity {
        return AluguelEntity(
            model.gamer.toEntity(),
            model.jogo.toEntity(),
            model.periodo
        ).apply {
            valorDoAluguel = model.valorAluguel,
            id = model.id
        }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(
            entity.gamer.toModel(),
            entity.jogo.toModel(),
            entity.periodo
        ).apply { id = entity.id }
    }

}