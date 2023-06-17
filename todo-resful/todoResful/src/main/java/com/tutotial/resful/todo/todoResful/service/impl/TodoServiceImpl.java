package com.tutotial.resful.todo.todoResful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutotial.resful.todo.todoResful.entity.Todo;
import com.tutotial.resful.todo.todoResful.repository.TodoRepository;
import com.tutotial.resful.todo.todoResful.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoRepository todoRepo;
	
	@Override
	public int countTodo() {
		return todoRepo.findAll().size();
	}

	@Override
	public Todo getTodo(int id) {
		return todoRepo.findById(id);
	}

	@Override
	public List<Todo> getAll() {
		return todoRepo.findAll();
	}

}
