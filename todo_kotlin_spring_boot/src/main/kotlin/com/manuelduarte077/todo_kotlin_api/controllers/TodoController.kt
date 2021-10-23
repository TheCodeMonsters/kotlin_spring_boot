package com.manuelduarte077.todo_kotlin_api.controllers

import com.manuelduarte077.todo_kotlin_api.entities.Todo
import com.manuelduarte077.todo_kotlin_api.entities.TodoRepository
import org.hibernate.sql.Update
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    // Consultar las tareas por medio del id de la tarea
    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo> {
        return todoRepository.findById(todoId)
    }

    // Registar una nueva tarea
    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo{
        return todoRepository.save(todo)
    }

    // Metodo para Actualizar la tarea
    @PutMapping("/{todoId}")
    fun updateTodo(@PathVariable("todoId") todoId: Long, @RequestBody updateTodo: Todo): Todo? {
        val oldTodo = todoRepository.findByIdOrNull(todoId)
        if (oldTodo == null){
             return oldTodo
        }

        return todoRepository.save(updateTodo)
    }

    // Metodo para eliminar un post
    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: Long){
        todoRepository.deleteById(todoId)
    }


}