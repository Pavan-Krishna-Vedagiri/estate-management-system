package com.pavan.github.estatemanagementsystem.exceptions.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
}
