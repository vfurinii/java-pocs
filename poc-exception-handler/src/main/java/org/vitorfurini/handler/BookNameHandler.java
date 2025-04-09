package org.vitorfurini.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.vitorfurini.exception.BookNameException;
import org.vitorfurini.model.ErrorDTO;

@ControllerAdvice
public class BookNameHandler {

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(BookNameException.class)
    public ErrorDTO handler(BookNameException ex) {
        return new ErrorDTO(
                ex.getMessage()
        );
    }
}
