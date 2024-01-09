package com.example.taskmanager.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.R
import com.example.taskmanager.databinding.HolderTaskBinding
import com.example.taskmanager.model.TasksModel

class TaskAdapter(private val viewModel: MyViewModel): RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    private var taskList = ArrayList<TasksModel>()

    inner class TaskHolder(val binding: HolderTaskBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderTaskBinding.inflate(layoutInflater, parent, false)
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task = taskList[position]
        holder.binding.tvTitle.text = task.title
        holder.binding.tvDesc.text = task.description
        holder.binding.tvDate.text = task.date

        holder.itemView.setOnLongClickListener {
            viewModel.deleteTask(task)
            return@setOnLongClickListener true
        }

        holder.binding.ivEdit.setOnClickListener {
            it.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    fun update(list: List<TasksModel>) {
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

}