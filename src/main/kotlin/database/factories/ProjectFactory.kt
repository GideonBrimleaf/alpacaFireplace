package com.alpaca.fireplace.database.factories

import com.alpaca.fireplace.entities.Project
import com.alpaca.fireplace.entities.Projects
import com.alpaca.fireplace.entities.User
import com.alpaca.fireplace.entities.Users
import dev.alpas.hashing.Hasher
import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import java.time.Instant

// https://alpas.dev/docs/entity-factory
internal class ProjectFactory() : EntityFactory<Project, Projects>() {
    override val table = Projects

    override fun entity(): Project {
        return Project {
            title = faker.lordOfTheRings().character()
            description = faker.lorem().paragraph()
            updatedAt = Instant.now()
            createdAt = Instant.now()
        }
    }
}
