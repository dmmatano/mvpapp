package com.dmwaresolutions.mvpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dmwaresolutions.mvpapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: TaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = TaskPresenter(this)

        binding.btnAdd.setOnClickListener {
            val newTask = TaskModel("Novo", "Descrição da nova tarefa", false)
            presenter.addTask(newTask)
        }
    }

    override fun showTasks(tasks: List<TaskModel>) {
        val adapter = TaskAdapter(tasks, this)
        binding.taskList.adapter = adapter

        binding.taskList.setOnItemLongClickListener { _, _, position, _ ->
            presenter.deleteTask(tasks[position])
            true
        }

        binding.taskList.setOnItemClickListener { _, _, position, _ ->
            presenter.updateTak(position)

        }
    }
}