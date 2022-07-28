package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxiliarPosition = new Position(0, 0);
		
		//above
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setRow(auxiliarPosition.getRow() - 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//left
		auxiliarPosition.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setColumn(auxiliarPosition.getColumn() - 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//right
		auxiliarPosition.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setColumn(auxiliarPosition.getColumn() + 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//below
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setRow(auxiliarPosition.getRow() + 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//nw
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn()- 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setValues(auxiliarPosition.getRow() - 1, auxiliarPosition.getColumn() - 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//ne
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setValues(auxiliarPosition.getRow() - 1, auxiliarPosition.getColumn() + 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//se
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setValues(auxiliarPosition.getRow() + 1, auxiliarPosition.getColumn() + 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//sw
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExists(auxiliarPosition) && !getBoard().thereIsAPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
			auxiliarPosition.setValues(auxiliarPosition.getRow() + 1, auxiliarPosition.getColumn() - 1);
		}
		if(getBoard().positionExists(auxiliarPosition) && isThereOpponentPiece(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		return mat;
	}
}
