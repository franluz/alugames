import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate
import kotlin.math.pow


fun generate(phrase: String): String {
    var retornoAcronomo:String = ""
    if (phrase.isNotEmpty()) {
        var acronomuns = phrase.filter{it.isLetter() or it.equals(' ')  or it.equals('-')}
            .split(" ", "-")
        println(acronomuns)
        var acron = acronomuns.filter { it.trim().length>0 }.map { it.trim().substring(0, 1) }.joinToString("")
        retornoAcronomo = acron.toString().uppercase()
    }
    return retornoAcronomo
}
fun check(input: Int): Boolean {
    val inputAsString = input.toString()
    val sum = input.toString().map {
        it.digitToInt().toDouble().pow(inputAsString.length.toDouble())
    }.sum()
    return sum == input.toDouble()
}
fun main2() {
    println(check(143))
}

fun main1() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamer()
    val jogoApi = consumo.buscaJogo("150")
    val listaJogoJson = consumo.buscaJogosJson()
//    println(listaGamer)
//    println(jogoApi)
    val gamerCaroline = listaGamer.get(3)
    val jogoResidenteVillace = listaJogoJson.get(10)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)
    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    gamerCaroline.alugaJogo(jogoResidenteVillace, periodo)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    var gamerCamila = listaGamer.get(5)

    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    gamerCamila.alugaJogo(jogoResidenteVillace, periodo)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    /*   println(gamerCaroline)
       println(jogoResidenteVillace)*/
    // println(gamerCaroline.jogosAlugados)
    println(gamerCamila)
    gamerCamila.alugaJogo(jogoResidenteVillace, periodo)
    println(gamerCamila.jogosAlugados)


    gamerCaroline.recomendarJogo(jogoResidenteVillace, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)
    println("Recomendacoes da Camila")
    println(gamerCamila.jogosRecomendados)
    println("Recomendacoes da Caroline")
    println(gamerCaroline.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        .create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println("Serializacao")
    println(serializacao)
    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)


}