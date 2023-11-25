import java.util.*

class Task(val description: String, val dueDate: String) {}

fun main() {
    val taskList = mutableListOf<Task>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Введите действие:")
        println("1. Добавить задачу")
        println("2. Просмотреть задачи")
        println("3. Выйти")

        when(scanner.next().toInt()) { // ?
            1 -> addTask(scanner, taskList)
            2 -> viewTasks(scanner, taskList)
            3 -> {
                println("Выход из приложения")
                return
            }
            else -> println("Некорректный ввод. Попробуйте снова")
        }
    }
}

fun addTask(scanner: Scanner, taskList: MutableList<Task>) {
    println("Введите описание задачи:")
    val description = scanner.next()

    println("Введите дату выполнения (например, 2023-11-26)")
    val dueDate = scanner.next()

    val newTask = Task(description, dueDate)
    taskList.add(newTask)

    println("Задача успешно добавлена")
}

fun viewTasks(scanner: Scanner, taskList: MutableList<Task>) {
    if (taskList.isEmpty()) {
        println("Список задач пуст")
    } else {
        println("Список задач:")
        for ((index, task) in taskList.withIndex()) {
            println("${index + 1}. Описание: ${task.description}, Дата выполнения ${task.dueDate}")
        }
    }
}
