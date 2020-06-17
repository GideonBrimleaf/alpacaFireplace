package com.alpaca.fireplace

import dev.alpas.Alpas
import java.io.File

fun main(args: Array<String>) {
    val file = File(".env")
    if (!file.exists()) {
        file.createNewFile()
    }
    return Alpas(args).routes { addRoutes() }.ignite()
}
