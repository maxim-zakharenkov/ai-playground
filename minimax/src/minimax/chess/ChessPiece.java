package minimax.chess;

public abstract class ChessPiece {

	private ChessPiece() {
	}
	
	public static byte EMPTY    = 0;
	
	public static byte W_PAWN   = 1;
	public static byte W_KNIGHT = 2;
	public static byte W_BISHOP = 3;
	public static byte W_ROOK   = 4;
	public static byte W_QUEEN  = 6;
	public static byte W_KING   = 7;
	
	public static byte B_PAWN   = 8;
	public static byte B_KNIGHT = 9;
	public static byte B_BISHOP = 10;
	public static byte B_ROOK   = 11;
	public static byte B_QUEEN  = 12;
	public static byte B_KING   = 13;
	
	public static boolean isWhite(byte piece) {
		return piece > 0 && piece < 8;
	}

	public static boolean isBlack(byte piece) {
		return piece > 7 && piece < 14;
	}
	
	public static boolean isSameColor(byte piece1, byte piece2) {
		return (isWhite(piece1) == isWhite(piece2)) || (isBlack(piece1) == isBlack(piece2));
	}
}
