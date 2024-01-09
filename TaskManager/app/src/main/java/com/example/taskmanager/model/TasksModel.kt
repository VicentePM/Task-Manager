package com.example.taskmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class TasksModel(
    var title: String,
    var description: String,
    var priority: Int,
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}