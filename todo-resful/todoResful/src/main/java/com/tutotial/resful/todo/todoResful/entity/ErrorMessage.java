package com.tutotial.resful.todo.todoResful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	private String message;
	private String statusCode;
}
