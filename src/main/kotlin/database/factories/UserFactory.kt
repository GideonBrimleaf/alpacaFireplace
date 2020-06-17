package com.alpaca.fireplace.database.factories

import com.alpaca.fireplace.entities.User
import com.alpaca.fireplace.entities.Users
import dev.alpas.hashing.Hasher
import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import java.time.Instant

// https://alpas.dev/docs/entity-factory
internal class UserFactory(private val hasher: Hasher) : EntityFactory<User, Users>() {
    override val table = Users

    override fun entity(): User {
        return User {
            email = faker.internet().safeEmailAddress()
            password = hasher.hash("secret")
            name = faker.name().name()
            updatedAt = Instant.now()
            createdAt = Instant.now()
        }
    }
}
