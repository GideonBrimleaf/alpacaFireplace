package com.alpaca.fireplace.database.migrations

import com.alpaca.fireplace.entities.Projects
import dev.alpas.ozone.migration.Migration

class CreateProjectsTable : Migration() {
    override var name = "2020_08_18_144205_create_projects_table"
    
    override fun up() {
        createTable(Projects)
    }
    
    override fun down() {
        dropTable(Projects)
    }
}