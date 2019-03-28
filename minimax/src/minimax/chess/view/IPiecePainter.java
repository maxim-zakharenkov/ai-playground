package minimax.chess.view;

import java.awt.Graphics2D;

import javax.swing.JComponent;

public interface IPiecePainter {

	void paintPiece(byte pieceType, JComponent component, Graphics2D g, int destX1, int destY1, int destX2, int destY2);
}
