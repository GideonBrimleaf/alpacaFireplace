package com.alpaca.fireplace.entities

import dev.alpas.auth.BaseUser
import dev.alpas.auth.BaseUsersTable
import dev.alpas.ozone.OzoneEntity
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.findList

// https://alpas.dev/docs/ozone#dao
interface User : BaseUser<User> {
    // https://alpas.dev/docs/email-verification
    override val mustVerifyEmail
//        get() = true
        get() = false

    val projects get() = Projects.findList { it.ownerId eq id }

    companion object : OzoneEntity.Of<User>()
}

// https://alpas.dev/docs/ozone#dsl
object Users : BaseUsersTable<User>()
