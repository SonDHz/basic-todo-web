package com.tutotial.resful.todo.todoResful.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tutotial.resful.todo.todoResful.entity.Todo;
import com.tutotial.resful.todo.todoResful.repository.TodoRepository;

@SpringBootTest
public class TestWithSpringBootTest {
	/**
     * Cách này sử dụng @SpringBootTest
     * Nó sẽ load toàn bộ Bean trong app của bạn lên,
     * Giống với việc chạy App.java vậy
     */
	@MockBean
	TodoRepository todoRepo;
	
	@Autowired
	TodoService todoService;
	
	@BeforeEach
	public void setUp() {
		Mockito.when(todoRepo.findAll())
			.thenReturn(IntStream.range(0, 10)
					.mapToObj(i -> new Todo("title-" + i, "detail-" + i))
					.collect(Collectors.toList()));
	}
	
	@Test
	public void testCount() {
		assertEquals(10, todoService.countTodo());
	}
}
