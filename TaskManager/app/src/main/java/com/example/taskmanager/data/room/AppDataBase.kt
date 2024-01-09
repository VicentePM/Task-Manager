package com.example.taskmanager.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanager.model.TasksModel

@Database([TasksModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun TaskDao(): TaskDao

    companion object {
        const val DBNAME = "tasks_database"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val temporalInstance = INSTANCE
            if(temporalInstance != null){
                return temporalInstance
            }

            synchronized(AppDataBase::class.java) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DBNAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}