package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece pieceExists = (ChessPiece)getBoard().piece(position);
		return pieceExists == null || pieceExists.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxiliarPosition = new Position(0, 0);
		
		//above
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//below
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//left
		auxiliarPosition.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//right
		auxiliarPosition.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//nw
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//ne
		auxiliarPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//sw
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		//se
		auxiliarPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(auxiliarPosition) && canMove(auxiliarPosition)) {
			mat[auxiliarPosition.getRow()][auxiliarPosition.getColumn()] = true;
		}
		
		// #special move castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// kingside rook
			Position posR1 = new Position(position.getRow(), position.getColumn() + 3);
			
			if(testRookCastling(posR1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				
				if(getBoard().piece(p1) ==  null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			// queenside rook
			Position posR2 = new Position(position.getRow(), position.getColumn() - 4);
			
			if(testRookCastling(posR1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				
				if(getBoard().piece(p1) ==  null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
			
		}
		
		return mat;
	}
}
