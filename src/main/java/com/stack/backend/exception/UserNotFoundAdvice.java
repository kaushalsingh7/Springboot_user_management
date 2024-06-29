package com.stack.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundAdvice {
@ExceptionHandler(UserNotFoundExceptions.class)
	public Map<String,String> exceptionHandler(UserNotFoundExceptions exception){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errormessage", exception.getMessage());
		return errorMap;
	}
}
