package com.example.kotlinspringtodo.controllers

import com.example.kotlinspringtodo.entities.Todo
import com.example.kotlinspringtodo.entities.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo> = todoRepository.findById(todoId)

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo = todoRepository.save(todo)

    @PutMapping("/{todoId}")
    fun updateTodo(@PathVariable("todoId") todoId: Long, @RequestBody updatedTodo: Todo): Todo? =
        todoRepository.findByIdOrNull(todoId)?.let { todoRepository.save(updatedTodo) }?: run { null }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: Long) = todoRepository.deleteById(todoId)
}