package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.JogoEntity
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import org.example.br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {


    override fun toEntity(model: Jogo): JogoEntity {
        return model.toEntity()

    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }

}