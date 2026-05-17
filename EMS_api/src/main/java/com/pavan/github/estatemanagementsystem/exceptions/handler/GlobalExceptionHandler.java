package com.pavan.github.estatemanagementsystem.exceptions.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = NoUserFoundException.class)
	public ResponseEntity<String> userNotFoundHandler(HttpServletRequest req, Exception exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatusCode.valueOf(404));
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> exceptionHandler(HttpServletRequest req, Exception exception){
		return new ResponseEntity<String>("Invalid username or password", HttpStatusCode.valueOf(404));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalExceptionHandler(HttpServletRequest req, Exception exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatusCode.valueOf(500));
	}
}
