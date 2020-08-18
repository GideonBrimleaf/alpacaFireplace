package com.alpaca.fireplace

import com.alpaca.fireplace.controllers.WelcomeController
import dev.alpas.auth.authRoutes
import dev.alpas.routing.RouteGroup
import dev.alpas.routing.Router

// https://alpas.dev/docs/routing
fun Router.addRoutes() = apply {
    group {
        webRoutesGroup()
        authRoutes()
//        authRoutes(requireEmailVerification = false)
    }.middlewareGroup("web")

    apiRoutes()
}

private fun RouteGroup.webRoutesGroup() {
    get("/", WelcomeController::index).name("welcome")
    // register more web routes here
}

private fun Router.apiRoutes() {
    // register API routes here
}
