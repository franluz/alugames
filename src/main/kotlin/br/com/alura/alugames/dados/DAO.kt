package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.JogoEntity
import javax.persistence.EntityManager

abstract class DAO<TModel>(protected val manager: EntityManager) {

    abstract fun toEntity(model:TModel)
    abstract fun getLista(): List<TModel>
    open fun adicionar(model:TModel){
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}