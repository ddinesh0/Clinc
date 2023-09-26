package com.example.hms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	protected ResponseEntity<Object> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
		Map<String,String>errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<Object>handlerResourceNotFoundException(ResourceNotFoundException ex){
		System.out.println(ex.getMessage());
		Map<String,String> errors=new HashMap<>();
		errors.put("Error", ex.getMessage());
		return new ResponseEntity<Object>(errors,HttpStatus.NOT_FOUND);
	}
	

}
