package com.alpaca.fireplace.database.migrations

import com.alpaca.fireplace.entities.Tasks
import dev.alpas.ozone.migration.Migration

class CreateTasksTable : Migration() {
    override var name = "2020_08_19_111445_create_tasks_table"
    
    override fun up() {
        createTable(Tasks)
    }
    
    override fun down() {
        dropTable(Tasks)
    }
}