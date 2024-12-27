import br.com.alura.alugames.modelo.Gamer

fun main1() {
    val gamer1 = Gamer("Nome", "jaque@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jeni",
        "jeni@email.com",
        "19/12/1992",
        usuario = "jeniblo"
    )
    println(gamer2)
    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jaqueskywalker"
    }.also {
        println(gamer1.idInterno)
    }
    println(gamer1)
    gamer1.usuario="Jaque"
    println(gamer1)

}