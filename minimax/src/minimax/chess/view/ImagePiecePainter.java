package minimax.chess.view;

import static minimax.chess.ChessPiece.B_BISHOP;
import static minimax.chess.ChessPiece.B_KING;
import static minimax.chess.ChessPiece.B_KNIGHT;
import static minimax.chess.ChessPiece.B_PAWN;
import static minimax.chess.ChessPiece.B_QUEEN;
import static minimax.chess.ChessPiece.B_ROOK;
import static minimax.chess.ChessPiece.W_BISHOP;
import static minimax.chess.ChessPiece.W_KING;
import static minimax.chess.ChessPiece.W_KNIGHT;
import static minimax.chess.ChessPiece.W_PAWN;
import static minimax.chess.ChessPiece.W_QUEEN;
import static minimax.chess.ChessPiece.W_ROOK;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

import minimax.chess.ChessPiece;

/**
 * Piece painter which use one image with all pieces defined.
 * The image is split into squared segments each contains
 * a separate piece's representation.
 **/
public class ImagePiecePainter implements IPiecePainter {

	public ImageSegment[] pieceSegments = new ImageSegment[14]; 
	
	public ImagePiecePainter(Image image, int cellSize) {
		
		pieceSegments[W_KING]   = new ImageSegment(image,  0, 		  0, cellSize, cellSize);
		pieceSegments[W_QUEEN]  = new ImageSegment(image,  cellSize,   0, cellSize, cellSize);
		pieceSegments[W_ROOK]   = new ImageSegment(image,  cellSize*2, 0, cellSize, cellSize);
		pieceSegments[W_BISHOP] = new ImageSegment(image,  cellSize*3, 0, cellSize, cellSize);
		pieceSegments[W_KNIGHT] = new ImageSegment(image,  cellSize*4, 0, cellSize, cellSize);
		pieceSegments[W_PAWN]   = new ImageSegment(image,  cellSize*5, 0, cellSize, cellSize);
		
		pieceSegments[B_KING]   = new ImageSegment(image,  0, 		  cellSize, cellSize, cellSize);
		pieceSegments[B_QUEEN]  = new ImageSegment(image,  cellSize,   cellSize, cellSize, cellSize);
		pieceSegments[B_ROOK]   = new ImageSegment(image,  cellSize*2, cellSize, cellSize, cellSize);
		pieceSegments[B_BISHOP] = new ImageSegment(image,  cellSize*3, cellSize, cellSize, cellSize);
		pieceSegments[B_KNIGHT] = new ImageSegment(image,  cellSize*4, cellSize, cellSize, cellSize);
		pieceSegments[B_PAWN]   = new ImageSegment(image,  cellSize*5, cellSize, cellSize, cellSize);
	}
	
	@Override
	public void paintPiece(byte pieceType, JComponent component, Graphics2D g,  int destX1, int destY1, int destX2, int destY2) {
		if(pieceType == ChessPiece.EMPTY) {
			return;
		}
		pieceSegments[pieceType].paint(component, g, destX1, destY1, destX2, destY2);;
	}
}
