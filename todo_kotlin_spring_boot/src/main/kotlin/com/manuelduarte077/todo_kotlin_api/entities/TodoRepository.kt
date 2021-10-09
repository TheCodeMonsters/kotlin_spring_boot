package com.manuelduarte077.todo_kotlin_api.entities;

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {
}