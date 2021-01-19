package zertificonsolutions.assignment.address.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import zertificonsolutions.assignment.address.entity.NotFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionMapper {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handle(ConstraintViolationException exception) {

        log.warn(exception.getMessage());
        return "Provided data already exist!";
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handle(NotFoundException exception) {

        log.warn(exception.getMessage());
        return exception.getMessage();
    }
}
