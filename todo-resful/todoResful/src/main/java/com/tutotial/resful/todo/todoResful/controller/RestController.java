package com.tutotial.resful.todo.todoResful.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutotial.resful.todo.todoResful.entity.Todo;

import jakarta.annotation.PostConstruct;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
	private List<Todo> todoList = new CopyOnWriteArrayList<>();
	
	@PostConstruct
	void init() {
		todoList.add(null);
	}
	
	@GetMapping("/todo")
	public List<Todo> getTodoList() {
		return todoList;
	}
	
	@GetMapping("/todo/{index}")
	public Todo getTodo(@PathVariable("index") Integer index) {
		return todoList.get(index);
	}
	
	/*
	    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
	    thành đối tượng Todo
     */
	@PutMapping("/todo/{index}")
	public Todo editTodo(@PathVariable("index") Integer index, @RequestBody Todo todo) {
		 todoList.set(index, todo);
		 return todoList.get(index);
	}
	
	@DeleteMapping("/todo/{index}")
	public ResponseEntity<?> deleteTodo(@PathVariable("index") Integer index) {
		todoList.remove(index.intValue());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/todo")
	public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
		todoList.add(todo);
		return ResponseEntity.ok().body(todo);
	}
	
}
