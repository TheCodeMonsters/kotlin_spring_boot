package com.manuelduarte077.todo_kotlin_api.entities

import javax.persistence.*

@Table(name = "todo")
@Entity
class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "completed")
    var completed: Boolean? = false
}