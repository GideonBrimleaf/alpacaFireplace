package com.alpaca.fireplace.controllers

import com.alpaca.fireplace.guards.CreateTasksGuard
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller

class TaskController : Controller() {
    fun store(call: HttpCall) {
        call.validateUsing(CreateTasksGuard::class) {
            val task = commit()
            call.replyAsJson(task)
        }
    }
}