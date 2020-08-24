package com.alpaca.fireplace.database.migrations

import com.alpaca.fireplace.entities.Activities
import dev.alpas.ozone.migration.Migration

class CreateActivitiesTable : Migration() {
    override var name = "2020_08_24_115456_create_activities_table"
    
    override fun up() {
        createTable(Activities)
    }
    
    override fun down() {
        dropTable(Activities)
    }
}