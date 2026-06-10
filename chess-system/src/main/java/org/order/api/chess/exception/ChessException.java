package org.order.api.chess.exception;

import org.order.api.boardgame.exception.BoardException;

public class ChessException extends BoardException {
    public ChessException(String message) {
        super(message);
    }
}
