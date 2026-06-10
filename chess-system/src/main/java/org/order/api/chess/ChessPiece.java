package org.order.api.chess;

import org.order.api.boardgame.Board;
import org.order.api.boardgame.Piece;
import org.order.api.boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOponentPiece(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece != null && chessPiece.getColor() != color;
    }
}
