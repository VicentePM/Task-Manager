package com.example.taskmanager.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.databinding.CreateTaskBinding
import com.example.taskmanager.model.TasksModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreateFragment : Fragment() {

    private var _binding: CreateTaskBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val myViewModel: MyViewModel by viewModels {
        MyViewModel.MyViewModelFactory(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CreateTaskBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            if(binding.tvPriority.text != "10"){
                val sum = binding.tvPriority.text.toString().toInt()
                binding.tvPriority.text = (sum + 1).toString()
            }
        }

        binding.minusButton.setOnClickListener {
            if(binding.tvPriority.text != "1"){
                val sum = binding.tvPriority.text.toString().toInt()
                binding.tvPriority.text = (sum - 1).toString()
            }
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.acceptButton.setOnClickListener {
            val title = binding.ipTitle.text.toString()
            val description = binding.ipDesc.text.toString()
            val date = getCurrentDateTime()
            val priority = binding.tvPriority.text.toString().toInt()

            if(title.isNotEmpty() && description.isNotEmpty()){
                val task = TasksModel(title, description, priority, date)
                myViewModel.insertTask(task)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Introduce todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getCurrentDateTime(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}