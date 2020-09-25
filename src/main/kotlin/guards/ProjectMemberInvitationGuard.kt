package com.alpaca.fireplace.guards

import com.alpaca.fireplace.entities.ProjectMemberships
import com.alpaca.fireplace.entities.User
import com.alpaca.fireplace.rules.ValidUserRule
import dev.alpas.orAbort
import dev.alpas.validation.Rule
import dev.alpas.validation.ValidationGuard
import dev.alpas.validation.email
import dev.alpas.validation.required
import me.liuwj.ktorm.dsl.insert

class ProjectMemberInvitationGuard : ValidationGuard() {
    private val validUserRule by lazy { ValidUserRule() }
    override fun rules(): Map<String, Iterable<Rule>> {
          return mapOf("email"  to listOf(required(), email(), validUserRule))
    }
    fun commit(): User {
        val now = call.nowInCurrentTimezone().toInstant()
        val member = validUserRule.user.orAbort()
        ProjectMemberships.insert {
            it.projectId to call.longParam("project")
            it.userId to member.id
            it.createdAt to now
            it.updatedAt to now
        }
        return member
    }
}