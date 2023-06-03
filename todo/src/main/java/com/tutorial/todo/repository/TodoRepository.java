package com.tutorial.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
}
