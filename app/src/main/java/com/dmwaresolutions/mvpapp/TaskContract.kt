package com.dmwaresolutions.mvpapp

interface TaskContract {
    interface View{
        fun showTasks(tasks: List<TaskModel>)
    }

    interface Presenter{
        fun getTasks()
        fun addTask(task: TaskModel)
        fun updateTak(position: Int)
        fun deleteTask(task: TaskModel)
    }
}