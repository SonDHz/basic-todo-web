package com.tutotial.resful.todo.todoResful.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.tutotial.resful.todo.todoResful.entity.ErrorMessage;

@RestControllerAdvice
public class ApiExceptionHandle {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleAllException(Exception ex, WebRequest request) {
		//Quá trình kiểm soát lỗi ở đây
		return new ErrorMessage(ex.getLocalizedMessage(), "100000");
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage todoException(Exception ex, WebRequest request) {
		return new ErrorMessage("Object is not exists", "10100");
	}
}
