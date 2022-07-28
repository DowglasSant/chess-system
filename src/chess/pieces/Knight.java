package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPiece pieceExists = (ChessPiece)getBoard().piece(position);
		return pieceExists == null || pieceExists.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxiliarPosition = new Position(0, 0);
		
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}

		auxiliarPosition.setValues(position.getRow() - 2, position.getColumn() - 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		return mat;
	}
}
