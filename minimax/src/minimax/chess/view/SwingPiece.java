package minimax.chess.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class SwingPiece extends JComponent {
	
	private IPiecePainter pieceSet;
	private byte pieceType;

	public SwingPiece(IPiecePainter pieceSet, byte pieceType) {
		this.pieceSet = pieceSet;
		this.pieceType = pieceType;
	}

	@Override
	protected void paintComponent(Graphics g) {
		pieceSet.paintPiece(pieceType, this, (Graphics2D)g, getX(), getY(), getX() + getWidth(), getY() + getHeight());
	}
}
