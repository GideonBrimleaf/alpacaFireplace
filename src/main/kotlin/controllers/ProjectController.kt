package com.alpaca.fireplace.controllers

import com.alpaca.fireplace.entities.Projects
import com.alpaca.fireplace.entities.User
import com.alpaca.fireplace.guards.CreateProjectGuard
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.ozone.create
import dev.alpas.ozone.findOrFail
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.delete
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.findAll

class ProjectController : Controller() {
    fun index(call: HttpCall) {
        val user = call.caller<User>()
        val projects = user.projects
        call.render("project_list", mapOf("projects" to projects))
    }

    fun create(call: HttpCall) {
        call.render("project_new")
    }

    fun store(call: HttpCall) {
        call.validateUsing(CreateProjectGuard::class) {
            val project = commit()
            flash("success", "Successfully added project ${project.title}")
        }
        call.redirect().toRouteNamed("projects.list")
    }

    fun delete(call:HttpCall) {
        val id = call.longParam("id").orAbort()
        Projects.delete {it.id eq id}
        flash("success", "Successfully deleted project")
        call.redirect().back()
    }

    fun show(call: HttpCall) {
        val id = call.longParam("id").orAbort()
        val project = Projects.findOrFail(id)
        call.render("project_show", mapOf("project" to project))
    }
}