package br.com.alura.alugames.modelo

import org.example.br.com.alura.alugames.modelo.Jogo
import java.util.*


data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    val plano: PlanoAvulso= PlanoAvulso("BRONZE")

    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        get
        private set
    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

//    init {
//        this.email = validarEmail()
//        this.nome = validaNome(nome)
//    }

    fun validaNome(value: String): String {
        if (value.isNullOrBlank()) {
            return throw java.lang.IllegalArgumentException("Nome precisa ser preenchido!")
        }
        return value
    }


    override fun toString(): String {
        return "\n Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = kotlin.random.Random.nextInt(100000)
        val tag = String.format("%04d", numero)
        idInterno = "$usuario#$tag"
    }

    @kotlin.Throws(IllegalArgumentException::class)
    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        }

        return throw IllegalArgumentException("Email invalid")

    }

    fun alugaJogo(jogo: Jogo,periodo:Periodo): Aluguel {
        val aluguel= Aluguel(this, jogo, periodo )
        jogosAlugados.add(aluguel)
        return aluguel

    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()
                return Gamer(nome, email, nascimento, usuario)
            }
            return Gamer(nome, email)
        }
    }

}
