package br.com.alura.alugames.utilitario

import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {
    fun ciphertext(plaintext: String): String {
        val normalized = plaintext.filter { it.isLetterOrDigit() }.lowercase()
        if (normalized.isEmpty()) {
            return ""
        }
        val colCount = ceil(sqrt(normalized.length.toDouble())).toInt()
        val rows = normalized.chunked(colCount) { it.padEnd(colCount) }
        val cols = (0 until colCount).map { colIdx -> rows.map { it[colIdx] }.joinToString("") }
        return cols.joinToString(" ")
    }
}

fun main() {
    val plaintext = "This is fun!"
    val expectedOutput = "tsf hiu isn"
    var outtput = CryptoSquare.ciphertext(
        plaintext
    )


    println(
        outtput
    )
    println(
        expectedOutput
    )
    println(expectedOutput.equals(outtput))
}




