package com.university.demo.error;

import com.university.demo.dto.ResponsePayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class DemoControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ResponsePayload>
    valiodationError(Exception e, WebRequest wq){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(ResponsePayload.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorMessage(e.getMessage()).build());
    }
}
