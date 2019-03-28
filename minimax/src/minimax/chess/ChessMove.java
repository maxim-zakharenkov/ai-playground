package minimax.chess;

import minimax.IMove;

public class ChessMove implements IMove {
	
	/** Piece type to move. Useful for undo move. */ 
	private final byte piece;
	
	private final int sourceCell;
	
	private final int destinationCell;
	
	/** Piece to be taken as a result of the move
	* When it is {@link ChessPiece#EMPTY}, it means 
	* that no piece is taken. Useful for undo move. */ 
	private final byte takePiece;
	
	/** Piece to promote pawn to when promotion takes place.
	 * It has {@link ChessPiece#EMPTY} when the move is not 
	 * connected to a pawn promotion */
	private final byte promoteToPiece;
	

	/** Move type described by {@ling ChessMoveType} constants. */
	private final byte moveType;

	public static final ChessMove WHITE_SHORT_CASTLE = new ChessMove(ChessPiece.W_KING, ChessCoordinate.E1, ChessCoordinate.G1, ChessPiece.EMPTY, ChessMoveType.W_SHORT_CASTLE, ChessPiece.EMPTY);
	public static final ChessMove WHITE_LONG_CASTLE = new ChessMove(ChessPiece.W_KING, ChessCoordinate.E1, ChessCoordinate.C1, ChessPiece.EMPTY, ChessMoveType.W_LONG_CASTLE, ChessPiece.EMPTY);
	public static final ChessMove BLACK_SHORT_CASTLE = new ChessMove(ChessPiece.W_KING, ChessCoordinate.E8, ChessCoordinate.G8, ChessPiece.EMPTY, ChessMoveType.B_SHORT_CASTLE, ChessPiece.EMPTY);
	public static final ChessMove BLACK_LONG_CASTLE = new ChessMove(ChessPiece.W_KING, ChessCoordinate.E8, ChessCoordinate.C8, ChessPiece.EMPTY, ChessMoveType.B_LONG_CASTLE, ChessPiece.EMPTY);
	
	public ChessMove(byte piece, int sourceCell, int destinationCell, byte takePiece, byte moveType, byte promoteToPiece) {
		super();
		this.piece = piece;
		this.sourceCell = sourceCell;
		this.destinationCell = destinationCell;
		this.takePiece = takePiece;
		this.moveType = moveType;
		this.promoteToPiece = promoteToPiece;
	}

	public byte getPiece() {
		return piece;
	}
	public int getSourceCell() {
		return sourceCell;
	}
	public int getDestinationCell() {
		return destinationCell;
	}
	public byte getTakePiece() {
		return takePiece;
	}
	public byte getMoveType() {
		return moveType;
	}
	
	public byte getPromoteToPiece() {
		return promoteToPiece;
	}
}
