package com.alpaca.fireplace.entities

import dev.alpas.ozone.*
import me.liuwj.ktorm.schema.long
import java.time.Instant

interface ProjectMembership : OzoneEntity<ProjectMembership> {
    var id: Long
//    who they are
    val member: User
    val project: Project
//    what project
    var createdAt: Instant?
    var updatedAt: Instant?

    companion object : OzoneEntity.Of<ProjectMembership>()
}

object ProjectMemberships : OzoneTable<ProjectMembership>("project_members") {
    val id by bigIncrements()
    val userId by long("user_id").belongsTo(Users) { it.member }
    val projectId by long("project_id").belongsTo(Projects) { it.project }
    val createdAt by createdAt()
    val updatedAt by updatedAt()
}