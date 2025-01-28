package com.example.hibernatetwo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hibernatetwo.controller.StudentController;

import jakarta.validation.UnexpectedTypeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

/*	@ExceptionHandler(value=StudentController.class)
	public String InValidEntityExceptions(MethodArgumentNotValidException ex) {
		
		List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
		
		String errorMessage = String.join(" ",errors);
		
		
		return errorMessage;
	}
*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		System.out.println("Inside Global Exception Handler!");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        //return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }
	
	@ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<String> handleUnexpectedTypeExceptions(UnexpectedTypeException ex) {
		System.out.println("Inside Global Exception Handler!");
       
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
       // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }
	
	//Handling CustomException
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map> customExceptnHandling(CustomException ce) {
		
		Map<String,String> map = new HashMap<>();
		map.put("Exception Name : ", ce+" Exception");
		map.put("message : ", "Exception occurred and Handled successfully!");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
	}
	
	
}
