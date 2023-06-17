package com.tutotial.resful.todo.todoResful.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.tutotial.resful.todo.todoResful.entity.Todo;
import com.tutotial.resful.todo.todoResful.repository.TodoRepository;
import com.tutotial.resful.todo.todoResful.service.impl.TodoServiceImpl;

@SpringBootTest
public class TestWithConfiguration {
	
	/**
     * Cách này sử dụng @TestConfiguration
     * Nó chỉ tạo ra Bean trong Context test này mà thôi
     * Tiết kiệm thời gian hơn khi sử dụng @SpringBootTest (vì phải load hết Bean lên mà không dùng đến)
     */
	@TestConfiguration
	public static class TodoServiceTestConfiguration {
		
		@Bean
		TodoServiceImpl todoServiceImpl() {
			return new TodoServiceImpl();
		}
	}
	
	@MockBean
	TodoRepository todoRepository;
	
	@Autowired
	private TodoServiceImpl todoServiceImpl;
	
	@BeforeEach
	public void setUp() {
		Mockito.when(todoRepository.findAll())
			.thenReturn(IntStream.range(0, 10)
					.mapToObj(i -> new Todo("title-" + i, "detail-" + i))
					.collect(Collectors.toList()));
	}
	
	@Test
	public void testCount() {
		System.out.println("test");
		assertEquals(10, todoServiceImpl.countTodo());
	}
}
