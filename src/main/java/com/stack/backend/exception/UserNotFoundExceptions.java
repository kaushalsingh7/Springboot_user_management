package com.stack.backend.exception;

public class UserNotFoundExceptions extends RuntimeException {
	public UserNotFoundExceptions(Long id) {
		super("could not found the user with id " + id);
	}

}
