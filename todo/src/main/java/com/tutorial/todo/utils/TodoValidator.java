package com.tutorial.todo.utils;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.tutorial.todo.entity.Todo;

@Component
public class TodoValidator {
	public boolean isValid(Todo todo) {
		return Optional.ofNullable(todo)
				.filter(t -> StringUtils.isEmpty(t.getTitle()))
				.filter(t -> StringUtils.isEmpty(t.getDetails()))
				.isEmpty();
	}
}
