package org.sad.classUTrepository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends RuntimeException{
	
	public ClassNotFoundException(String message) {
		super(message);
	}
	public ClassNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
}
