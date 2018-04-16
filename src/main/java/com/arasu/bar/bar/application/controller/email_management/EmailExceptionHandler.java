package com.arasu.bar.bar.application.controller.email_management;

import com.arasu.bar.bar.responses.GeneralResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GeneralResponse errorException(DataIntegrityViolationException ex) {
        return new GeneralResponse(false, "Email already exist");
//        return new GeneralResponse(false, ex.getMessage());
    }
}
