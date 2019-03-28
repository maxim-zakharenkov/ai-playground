package minimax.chess;

import static minimax.chess.ChessCoordinate.A1;
import static minimax.chess.ChessCoordinate.A2;
import static minimax.chess.ChessCoordinate.A7;
import static minimax.chess.ChessCoordinate.A8;
import static minimax.chess.ChessCoordinate.B1;
import static minimax.chess.ChessCoordinate.B2;
import static minimax.chess.ChessCoordinate.B7;
import static minimax.chess.ChessCoordinate.B8;
import static minimax.chess.ChessCoordinate.C1;
import static minimax.chess.ChessCoordinate.C2;
import static minimax.chess.ChessCoordinate.C7;
import static minimax.chess.ChessCoordinate.C8;
import static minimax.chess.ChessCoordinate.D1;
import static minimax.chess.ChessCoordinate.D2;
import static minimax.chess.ChessCoordinate.D7;
import static minimax.chess.ChessCoordinate.D8;
import static minimax.chess.ChessCoordinate.E1;
import static minimax.chess.ChessCoordinate.E2;
import static minimax.chess.ChessCoordinate.E7;
import static minimax.chess.ChessCoordinate.E8;
import static minimax.chess.ChessCoordinate.F1;
import static minimax.chess.ChessCoordinate.F2;
import static minimax.chess.ChessCoordinate.F7;
import static minimax.chess.ChessCoordinate.F8;
import static minimax.chess.ChessCoordinate.G1;
import static minimax.chess.ChessCoordinate.G2;
import static minimax.chess.ChessCoordinate.G7;
import static minimax.chess.ChessCoordinate.G8;
import static minimax.chess.ChessCoordinate.H1;
import static minimax.chess.ChessCoordinate.H2;
import static minimax.chess.ChessCoordinate.H7;
import static minimax.chess.ChessCoordinate.H8;
import static minimax.chess.ChessPiece.B_BISHOP;
import static minimax.chess.ChessPiece.B_KING;
import static minimax.chess.ChessPiece.B_KNIGHT;
import static minimax.chess.ChessPiece.B_PAWN;
import static minimax.chess.ChessPiece.B_QUEEN;
import static minimax.chess.ChessPiece.B_ROOK;
import static minimax.chess.ChessPiece.EMPTY;
import static minimax.chess.ChessPiece.W_BISHOP;
import static minimax.chess.ChessPiece.W_KING;
import static minimax.chess.ChessPiece.W_KNIGHT;
import static minimax.chess.ChessPiece.W_PAWN;
import static minimax.chess.ChessPiece.W_QUEEN;
import static minimax.chess.ChessPiece.W_ROOK;

import java.util.Collection;

import minimax.IMove;
import minimax.IPosition;

public class ChessPosition implements IPosition {

	byte[] field;
	
	// true if next turn is for white and false otherwise
	private boolean nextTurnWhite;
	
	// king was not moved and castling was not done yet for white
	private boolean whiteCastlingAllowed;
	
	// king was not moved and castling was not done yet for black
	private boolean blackCastlingAllowed;
	
	public ChessPosition() {
		this.field = new byte[64];
	}
	
	public void arrangePieces() {
		
		for(int i = 0; i < this.field.length; i ++) {
			this.field[i] = EMPTY;
		}
		
		this.field[A1] = W_ROOK; 
		this.field[B1] = W_KNIGHT;
		this.field[C1] = W_BISHOP;
		this.field[D1] = W_QUEEN;
		this.field[E1] = W_KING;
		this.field[F1] = W_BISHOP;
		this.field[G1] = W_KNIGHT;
		this.field[H1] = W_ROOK;
		
		this.field[A2] = W_PAWN; 
		this.field[B2] = W_PAWN;
		this.field[C2] = W_PAWN;
		this.field[D2] = W_PAWN;
		this.field[E2] = W_PAWN;
		this.field[F2] = W_PAWN;
		this.field[G2] = W_PAWN;
		this.field[H2] = W_PAWN;
		
		this.field[A7] = B_PAWN; 
		this.field[B7] = B_PAWN;
		this.field[C7] = B_PAWN;
		this.field[D7] = B_PAWN;
		this.field[E7] = B_PAWN;
		this.field[F7] = B_PAWN;
		this.field[G7] = B_PAWN;
		this.field[H7] = B_PAWN;
		
		this.field[A8] = B_ROOK;   
		this.field[B8] = B_KNIGHT;
		this.field[C8] = B_BISHOP;
		this.field[D8] = B_QUEEN; 
		this.field[E8] = B_KING;  
		this.field[F8] = B_BISHOP;
		this.field[G8] = B_KNIGHT;
		this.field[H8] = B_ROOK; 
		
		this.nextTurnWhite = true;
		this.whiteCastlingAllowed = true;
		this.blackCastlingAllowed = true;
	}
	
	@Override
	public Collection<IMove> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doMove(IMove move) {
		// TODO Auto-generated method stub
	
		// TODO: Update under attack matrix
		
		nextTurnWhite = !nextTurnWhite;
	}

	@Override
	public void undoLastMove() {
		// TODO Auto-generated method stub
		
		nextTurnWhite = !nextTurnWhite;
	}
	
	@Override
	public boolean isNextPlayerValuePositive() {
		return nextTurnWhite;
	}

	/** Returns piece at board using x,y system. x & y are in [0,7] */
	public byte getPieceAt(int x, int y) {
		return field[toCell(x,y)];
	}
	
	public Collection<IMove> getPossibleMovesAt(int cell, Collection<IMove> dest) {
		byte pieceType = field[cell];
		if(nextTurnWhite) {
			if(pieceType == W_PAWN) {
				getPossibleMovesForWhitePawn(cell, dest);
			} else if(pieceType == W_KNIGHT) {
				getPossibleMovesForWhiteKnight(cell, dest);
			} else if(pieceType == W_BISHOP) {
				getPossibleMovesForWhiteBishop(cell, dest);
			} else if(pieceType == W_ROOK) {
				getPossibleMovesForWhiteRook(cell, dest);
			} else if(pieceType == W_QUEEN) {
				return getPossibleMovesForWhiteQueen(cell, dest);
			} else if(pieceType == W_KING) {
				return getPossibleMovesForWhiteKing(cell, dest);
			} 
		} else {
			if(pieceType == B_PAWN) {
				getPossibleMovesForBlackPawn(cell, dest);
			} else if(pieceType == B_KNIGHT) {
				getPossibleMovesForBlackKnight(cell, dest);
			} else if(pieceType == B_BISHOP) {
				getPossibleMovesForBlackBishop(cell, dest);
			} else if(pieceType == B_ROOK) {
				getPossibleMovesForBlackRook(cell, dest);
			} else if(pieceType == B_QUEEN) {
				getPossibleMovesForBlackQueen(cell, dest);
			} else if(pieceType == B_KING) {
				getPossibleMovesForBlackKing(cell, dest);
			} 
		}
		return dest;
	}

	private Collection<IMove> getPossibleMovesForBlackKing(int cell, Collection<IMove> dest) {
		if(blackCastlingAllowed) {
			if(canBlackKingShortCastle(cell)) {
				dest.add(ChessMove.BLACK_SHORT_CASTLE);
			}
			if(canBlackKingShortCastle(cell)) {
				dest.add(ChessMove.BLACK_LONG_CASTLE);
			}
		}
		return null;
	}

	private boolean canBlackKingShortCastle(int cell) {
		// TODO Auto-generated method stub
		return false;
	}

	private Collection<IMove> getPossibleMovesForBlackQueen(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForBlackRook(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForBlackBishop(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForBlackKnight(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForBlackPawn(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	void addMoveIf(boolean condition, byte thisPiece, int srcCell, int x, int y, byte emptyMoveType, byte takeMoveType, byte promoteToPiece, Collection<IMove> dest) {
		if(condition) {
			int destCell = x + 1 + y*8;
			byte takePiece = field[destCell];
			if(ChessPiece.isSameColor(thisPiece, takePiece)) { 
				byte moveType = (takePiece == ChessPiece.EMPTY) ? emptyMoveType : takeMoveType;
				dest.add(new ChessMove(thisPiece, srcCell, destCell, takePiece, moveType, promoteToPiece));
			}
		}
	}
	
	private Collection<IMove> getPossibleMovesForWhiteKing(int srcCell, Collection<IMove> dest) {
		if(whiteCastlingAllowed) {
			if(canWhiteKingShortCastle()) {
				dest.add(ChessMove.WHITE_SHORT_CASTLE);
			}
			if(canWhiteKingLongCastle()) {
				dest.add(ChessMove.WHITE_LONG_CASTLE);
			}
		}
		
		int x = srcCell % 8;
		int y = srcCell / 8;
		byte thisPiece = ChessPiece.W_KING;
		byte emptyMoveType = ChessMoveType.W_MOVE;
		byte takeMoveType = ChessMoveType.W_TAKE;
		boolean opponentColor = ChessColor.BLACK;
		
		addMoveIf(x < 7 && !isCellUnderAttackOfColor(x + 1, y, opponentColor), thisPiece, srcCell, x + 1, y, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		addMoveIf(x < 7 && y < 7 && !isCellUnderAttackOfColor(x + 1, y + 1, opponentColor), thisPiece, srcCell, x + 1, y + 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		addMoveIf(x < 7 && y > 0 && !isCellUnderAttackOfColor(x + 1, y - 1, opponentColor), thisPiece, srcCell, x + 1, y - 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		
		addMoveIf(x > 0 && !isCellUnderAttackOfColor(x - 1, y, opponentColor), thisPiece, srcCell, x - 1, y, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		addMoveIf(x > 0 && y < 7 && !isCellUnderAttackOfColor(x - 1, y + 1, opponentColor), thisPiece, srcCell, x - 1, y + 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		addMoveIf(x > 0 && y > 0 && !isCellUnderAttackOfColor(x - 1, y - 1, opponentColor), thisPiece, srcCell, x - 1, y - 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		
		addMoveIf(y < 7 && !isCellUnderAttackOfColor(x, y + 1, opponentColor), thisPiece, srcCell, x, y + 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		addMoveIf(y > 0 && !isCellUnderAttackOfColor(x, y - 1, opponentColor), thisPiece, srcCell, x, y - 1, emptyMoveType, takeMoveType, ChessPiece.EMPTY, dest);
		
		return dest;
	}


	private boolean canWhiteKingLongCastle() {
		return 
				field[E1] == ChessPiece.W_KING
					&& field[A1] == ChessPiece.W_ROOK 
					&& field[B1] == ChessPiece.EMPTY
					&& field[C1] == ChessPiece.EMPTY
					&& field[D1] == ChessPiece.EMPTY
					&& !isCellUnderAttackOfColor(C1, ChessColor.BLACK)
					&& !isCellUnderAttackOfColor(D1, ChessColor.BLACK);
	}
	
	private boolean isCellUnderAttackOfColor(int x, int y, boolean color) {
		return isCellUnderAttackOfColor(toCell(x, y), color);
	}

	private int toCell(int x, int y) {
		return x + y*8;
	}

	private boolean isCellUnderAttackOfColor(int cell, boolean color) {
		
		return false;
	}

	private boolean canWhiteKingShortCastle() {
		// TODO Auto-generated method stub
		return false;
	}

	private Collection<IMove> getPossibleMovesForWhiteQueen(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForWhiteRook(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForWhiteBishop(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForWhiteKnight(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<IMove> getPossibleMovesForWhitePawn(int cell, Collection<IMove> dest) {
		// TODO Auto-generated method stub
		return null;
	}
}
