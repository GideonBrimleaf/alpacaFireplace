package com.alpaca.fireplace.controllers

import com.alpaca.fireplace.entities.Tasks
import com.alpaca.fireplace.guards.CreateTasksGuard
import com.alpaca.fireplace.guards.UpdateTasksGuard
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.delete
import me.liuwj.ktorm.dsl.eq

class TaskController : Controller() {
    fun store(call: HttpCall) {
        call.validateUsing(CreateTasksGuard::class) {
            val task = commit()
            call.replyAsJson(task)
        }
    }

    fun delete(call: HttpCall) {
        val taskId = call.longParam("id").orAbort()
        Tasks.delete { it.id eq taskId }
        call.acknowledge()
    }

    fun update(call: HttpCall) {
        call.validateUsing(UpdateTasksGuard::class) {
            val Task = commit()
            call.acknowledge()
        }
    }
}