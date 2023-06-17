package com.tutotial.resful.todo.todoResful.repository;

import java.util.List;

import com.tutotial.resful.todo.todoResful.entity.Todo;

public interface TodoRepository {
	List<Todo> findAll();
	
	Todo findById(int id);
}
