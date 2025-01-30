package br.com.alura.alugames.modelo

import javax.persistence.*

@Entity
@Table(name="planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(val tipo: String,@Id @GeneratedValue(strategy = GenerationType.IDENTITY) open val id: Int)

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(tipo: String="Avulso",
                        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                        override val id:Int=0) : PlanoEntity(tipo,id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String ="Assinatura",
    val mensalidade: Double=0.0,
    val jogosIncluidos: Int=0,
    val percentualDescontoReputacao: Double=0.0,
    override val id: Int=0
) : PlanoEntity(tipo,id)