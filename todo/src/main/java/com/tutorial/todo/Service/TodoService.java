package com.tutorial.todo.Service;

import java.util.List;

import com.tutorial.todo.entity.Todo;

public interface TodoService {
	public List<Todo> findAll(Integer limit);
	
	public Todo add(Todo todo);
}
