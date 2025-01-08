import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import org.example.br.com.alura.alugames.modelo.Jogo
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamer()
    val jogoApi = consumo.buscaJogo("150")
    val listaJogoJson = consumo.buscaJogosJson()
//    println(listaGamer)
//    println(jogoApi)
    val gamerCaroline = listaGamer.get(3)
    val jogoResidenteVillace = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(3)
    val jogoTheLastOfUs = listaJogoJson.get(2)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    gamerCaroline.alugaJogo(jogoResidenteVillace, periodo)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    var gamerCamila = listaGamer.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3,0.15)
    gamerCamila.alugaJogo(jogoResidenteVillace,periodo)
    gamerCamila.alugaJogo(jogoSpider,periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs,periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs,periodo3)
    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    /*   println(gamerCaroline)
       println(jogoResidenteVillace)*/
   // println(gamerCaroline.jogosAlugados)
    println(gamerCamila)
    gamerCamila.alugaJogo(jogoResidenteVillace,periodo)
    println(gamerCamila.jogosAlugados)

}