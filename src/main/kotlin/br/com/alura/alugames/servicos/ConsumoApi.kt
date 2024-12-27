package br.com.alura.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

class ConsumoApi {
    fun buscaJogo(id: String) :InfoJogo{
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()
        val meuInfoJogo: InfoJogo = gson.fromJson(json, InfoJogo::class.java)
        return meuInfoJogo
    }
}