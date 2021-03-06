package com.alpaca.fireplace.controllers

import com.alpaca.fireplace.entities.Activities
import com.alpaca.fireplace.entities.Projects
import com.alpaca.fireplace.entities.Task
import com.alpaca.fireplace.entities.User
import com.alpaca.fireplace.guards.ProjectMemberInvitationGuard
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.entity.findById

class ProjectMembershipController : Controller() {
    fun add(call: HttpCall) {
        call.validateUsing(ProjectMemberInvitationGuard::class) {
            val member = commit()
            logMembershipActivity(member)
            flash("success", "${member.name} <${member.email}> is now a member of this project")
            call.redirect().back()
        }
    }

    private fun logMembershipActivity(member: User) {
        val now = call.nowInCurrentTimezone().toInstant()
        val user = caller<User>()
        val projectId = call.longParam("project").orAbort()
        val project = Projects.findById(projectId).orAbort()
        Activities.insert {
            it.payload to mapOf("action" to "invited", "title" to project.title, "member" to member.name)
            it.projectId to projectId
            it.userId to user.id
            it.createdAt to now
            it.updatedAt to now
        }
    }
}