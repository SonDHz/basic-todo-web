package com.tutorial.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.todo.Service.TodoService;
import com.tutorial.todo.entity.Todo;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@GetMapping("/listTodo")
	public String index(Model model, @RequestParam(value = "limit", required = false ) Integer limit) {
		List<Todo> todoList = todoService.findAll(limit);
		model.addAttribute("todoList", todoList);
		return "listTodo";
	}
	
	@GetMapping("/addTodo")
	public String addTodo(Model model) {
		model.addAttribute("todo", new Todo());
		return "addTodo";
	}
	
    // @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
	@PostMapping("/addTodo")
	public String addTodo(@ModelAttribute Todo todo) {
		return Optional.ofNullable(todoService.add(todo))
				.map(t -> "success")
				.orElse("failed");
	}
}
