package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.JogoEntity
import org.example.br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo,JogoEntity>(manager,JogoEntity::class.java) {



    override fun toEntity(model: Jogo) :JogoEntity{
        return JogoEntity(
            model.titulo,
            model.capa,
            model.preco,
            model.descricao,
            model.Id
        )

    }

    override fun toModel(entity: JogoEntity): Jogo {
      return  Jogo(
          entity.titulo,
          entity.capa, entity.preco,
          entity.descricao, entity.Id
      )
    }

}