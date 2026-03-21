package com.pavan.github.estatemanagementsystem.exceptions.handler;

import com.pavan.github.estatemanagementsystem.dto.CommonResponseTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<CommonResponseTO> userNotFoundHandler(HttpServletRequest request, NoUserFoundException exception){

		CommonResponseTO response = CommonResponseTO.builder()
				.requestId(UUID.randomUUID().toString())
				.respondedTime(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.toString())
				.responseMessage(exception.getMessage())
				.responseCode(HttpStatus.NOT_FOUND.toString())
				.resourceName("USER")
				.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonResponseTO> exceptionHandler(HttpServletRequest request, Exception exception){
		CommonResponseTO response = CommonResponseTO.builder()
				.requestId(UUID.randomUUID().toString())
				.respondedTime(LocalDateTime.now())
				.responseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
				.responseMessage(exception.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
				.build();
		return ResponseEntity.internalServerError().body(response);
	}
}
