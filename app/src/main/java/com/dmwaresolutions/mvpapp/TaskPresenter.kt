package com.dmwaresolutions.mvpapp

class TaskPresenter(
    private val view: TaskContract.View
): TaskContract.Presenter {

    private val tasks = mutableListOf<TaskModel>()

    override fun getTasks() {
        view.showTasks(tasks)
    }

    override fun addTask(task: TaskModel) {
        task.id = tasks.size
        tasks.add(task)
        view.showTasks(tasks)
    }

    override fun updateTak(position: Int) {
        tasks[position].isCompleted = !tasks[position].isCompleted
        view.showTasks(tasks)
    }

    override fun deleteTask(task: TaskModel) {
        tasks.remove(task)
        view.showTasks(tasks)
    }
}