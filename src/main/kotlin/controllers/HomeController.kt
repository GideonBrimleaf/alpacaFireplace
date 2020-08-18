package com.alpaca.fireplace.controllers

import dev.alpas.auth.middleware.VerifiedEmailOnlyMiddleware
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller
import dev.alpas.routing.ControllerMiddleware

class HomeController : Controller() {
//    Comment out below to disable email verification
//    override fun middleware(call: HttpCall) = listOf(ControllerMiddleware(VerifiedEmailOnlyMiddleware::class))

    fun index(call: HttpCall) {
        call.render("home")
    }
}