package org.vitorfurini.exception;

import lombok.Getter;

@Getter
public class BookNameException extends RuntimeException {
    public BookNameException(String message) {
        super(message);
    }

}
