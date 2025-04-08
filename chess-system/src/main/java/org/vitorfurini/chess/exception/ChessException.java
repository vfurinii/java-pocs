package org.vitorfurini.chess.exception;

import org.vitorfurini.boardgame.exception.BoardException;

public class ChessException extends BoardException {
    public ChessException(String message) {
        super(message);
    }
}
