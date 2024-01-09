package com.example.taskmanager.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskmanager.model.TasksModel

@Dao
interface TaskDao {

    @Query("SELECT * FROM TasksModel ORDER BY priority DESC")
    fun getAllTasks(): LiveData<List<TasksModel>>

    @Insert
    suspend fun insertTask(task: TasksModel)

    @Query("DELETE FROM TasksModel")
    suspend fun deleteAllTasks()

    @Delete
    suspend fun deleteTask(task: TasksModel)

    @Update
    suspend fun updateTask(task: TasksModel)

}