package com.alpaca.fireplace.database.migrations

import com.alpaca.fireplace.entities.ProjectMemberships
import dev.alpas.ozone.migration.Migration

class CreateProjectMembershipsTable : Migration() {
    override var name = "2020_09_22_85650_create_project_memberships_table"
    
    override fun up() {
        createTable(ProjectMemberships)
    }
    
    override fun down() {
        dropTable(ProjectMemberships)
    }
}