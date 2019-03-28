package minimax.chess.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

import minimax.chess.ChessPosition;

@SuppressWarnings("serial")
public class SwingChessBoard extends JComponent {

	
	private static final Color WHITE_COLOR = Color.WHITE;
	private static final Color BLACK_COLOR = Color.LIGHT_GRAY;
	private ChessPosition position;
	private IPiecePainter pieceSet;

	public SwingChessBoard() {
	}
	
	public void setPieceSet(IPiecePainter pieceSet) {
		this.pieceSet = pieceSet;
	}
	
	public void setPosition(ChessPosition position) {
		this.position = position;
	}
	
	@Override
	protected void paintComponent(Graphics _g) {
		
		Graphics2D g = (Graphics2D)_g;
		int size = Math.min(getWidth()/8, getHeight()/8)*8;
		int cellSize = size/8;
		
		int dx = getWidth() - size;
		int dy = getHeight() - size;
		
		
		// Transform coordinates so that (0,0) is located in the bottom-left corner
		// and board is centered
		// AffineTransform(double m00, double m10, double m01, double m11, double m02, double m12)
		//       [ x']   [  m00  m01  m02  ] [ x ]   [ m00x + m01y + m02 ]
		//	     [ y'] = [  m10  m11  m12  ] [ y ] = [ m10x + m11y + m12 ]
		//	     [ 1 ]   [   0    0    1   ] [ 1 ]   [         1         ]
		g.setTransform(new AffineTransform(1.0, 0.0, 0.0, 1.0, dx/2, dy/2));
		
		
		g.setColor(WHITE_COLOR);
		g.fillRect(0, 0, size, size);
		
		
		g.setColor(BLACK_COLOR);
		for(int j = 0; j < 8; j ++) {
			for(int i = 0; i < 8; i ++) {
				if((i + j) % 2 == 1) {
					g.fillRect(cellSize*i, cellSize*j, cellSize, cellSize);
				}
				pieceSet.paintPiece(position.getPieceAt(i, 7 - j), this, g, cellSize*i, cellSize*j, cellSize*(i + 1), cellSize*(j + 1));
			}
		}
	}
}
