package com.example.taskmanager.data

import androidx.lifecycle.LiveData
import com.example.taskmanager.data.room.TaskDao
import com.example.taskmanager.model.TasksModel

class Repository(private val taskDao: TaskDao) {

    fun getAllTasks(): LiveData<List<TasksModel>> {
        return taskDao.getAllTasks()
    }

    suspend fun insertTask(task: TasksModel) {
        taskDao.insertTask(task)
    }

    suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }

    suspend fun deleteTask(task: TasksModel) {
        taskDao.deleteTask(task)
    }

    suspend fun updateTask(task: TasksModel){
        taskDao.updateTask(task)
    }

}