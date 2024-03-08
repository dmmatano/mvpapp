package com.dmwaresolutions.mvpapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListAdapter
import android.widget.TextView

class TaskAdapter(
    private val tasks: List<TaskModel>,
    private val context: Context
): BaseAdapter() {
    override fun getCount(): Int {
        return tasks.size
    }

    override fun getItem(position: Int): TaskModel {
        return tasks[position]
    }

    override fun getItemId(position: Int): Long {
        return tasks[position].id?.toLong()?: 0L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_task, parent, false)
        val titleTv = view.findViewById<TextView>(R.id.titleTask)
        val descriptionTv = view.findViewById<TextView>(R.id.descriptionTask)
        val checkBox = view.findViewById<CheckBox>(R.id.checkboxIsCompleted)
        val task = tasks[position]

        titleTv.text = task.title
        descriptionTv.text = task.description
        checkBox.isChecked = task.isCompleted

        return view
    }
}