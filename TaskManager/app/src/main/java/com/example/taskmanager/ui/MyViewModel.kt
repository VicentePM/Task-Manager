package com.example.taskmanager.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanager.data.Repository
import com.example.taskmanager.data.room.AppDataBase
import com.example.taskmanager.model.TasksModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context): ViewModel() {

    private val taskDao = AppDataBase.getDatabase(context).TaskDao()
    private val repository = Repository(taskDao)

    val allTasks = repository.getAllTasks()

    fun insertTask(task: TasksModel) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertTask(task)
        }
    }

    fun deleteAllTasks() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteAllTasks()
        }
    }

    fun deleteTask(task: TasksModel) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteTask(task)
        }
    }

    fun updateTask(task: TasksModel) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateTask(task)
        }
    }


    class MyViewModelFactory(val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java)
                .newInstance(context)
        }
    }

}