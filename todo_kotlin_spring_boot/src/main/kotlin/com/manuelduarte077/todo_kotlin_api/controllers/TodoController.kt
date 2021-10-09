package com.manuelduarte077.todo_kotlin_api.controllers

import com.manuelduarte077.todo_kotlin_api.entities.Todo
import com.manuelduarte077.todo_kotlin_api.entities.TodoRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository) {

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo{
        return todoRepository.save(todo);
    }
}