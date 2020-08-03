package com.sarcobjects.DevOffDesafio2

import org.springframework.stereotype.Service

@Service
class Crypter {

    fun encrypt(ask: Ask): Response {
        val (cols, mensaje) = ask
        val rows = calculateRows(mensaje, cols)
        val matrix = Array(cols) { Array(rows) { "" } }

        return Response(transposeAndExtract(matrix, mensaje, cols, rows))
    }

    fun decrypt(ask: Ask): Response {
        val (cols, mensaje) = ask
        val rows = calculateRows(mensaje, cols)
        val matrix = Array(rows) { Array(cols) { "" } }

        return Response(transposeAndExtract(matrix, mensaje, rows, cols))
    }

    private fun transposeAndExtract(
            matrix: Array<Array<String>>,
            mensaje: String,
            cols: Int,
            rows: Int): String {

        matrix.forEach { arr -> arr.forEach { println(it) } }


        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val i = row * cols + col
                matrix[col][row] = if (i <= mensaje.lastIndex) mensaje[i].toString() else ""
            }
        }
        return matrix.joinToString("") { a -> a.joinToString("") { c -> c.toString() } }
    }

    private fun calculateRows(mensaje: String, vueltas: Int): Int {
        val n = mensaje.length / vueltas
        return if (mensaje.length % vueltas == 0) n else n + 1
    }
}