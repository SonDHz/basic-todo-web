package com.tutotial.resful.todo.todoResful.service;

import java.util.List;

import com.tutotial.resful.todo.todoResful.entity.Todo;

public interface TodoService {
	int countTodo();
	Todo getTodo(int id);
	List<Todo> getAll();
}
