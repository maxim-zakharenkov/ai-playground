package minimax.chess;

public interface ChessMoveType {


	/** White moves to empty cell */
	public static final byte W_MOVE = 0;
	
	/** Black moves to empty cell */
	public static final byte B_MOVE = 1;
	
	/** White takes black's piece */
	public static final byte W_TAKE = 2;
	
	/** Black takes white's piece */
	public static final byte B_TAKE = 3;
	
	/** White short castling */
	public static final byte W_SHORT_CASTLE = 4;
	
	/** White long castling */
	public static final byte W_LONG_CASTLE = 5;
	
	/** Black short castling */
	public static final byte B_SHORT_CASTLE = 6;
	
	/** Black long castling */
	public static final byte B_LONG_CASTLE = 7;
	
	/** Black promotes pawn */
	public static final byte B_PROMOTION = 8;
	
	/** White promotes pawn */
	public static final byte W_PROMOTION = 9;
}
