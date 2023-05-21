package com.tutorial.todo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tutorial.todo.Service.TodoService;
import com.tutorial.todo.entity.Todo;
import com.tutorial.todo.repository.TodoRepository;
import com.tutorial.todo.utils.TodoValidator;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoValidator todoValidator;
	
	@Override
	public List<Todo> findAll(Integer limit) {
		return Optional.ofNullable(limit)
				.map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
				.orElseGet(() -> todoRepository.findAll());
	}

	@Override
	public Todo add(Todo todo) {
		if(todoValidator.isValid(todo)) {
			todoRepository.save(todo);
		}
		return null;
	}

}
