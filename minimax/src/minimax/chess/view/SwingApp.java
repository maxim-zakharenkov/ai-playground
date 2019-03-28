package minimax.chess.view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import minimax.chess.ChessPosition;

public class SwingApp {

	public static void main(String[] args) throws IOException {

		SwingChessBoard swingChessBoard = new SwingChessBoard();
		ChessPosition position = new ChessPosition();
		position.arrangePieces();
		
		BufferedImage img = ImageIO.read(SwingPiece.class.getResourceAsStream("/images/pieces.png"));
		swingChessBoard.setPieceSet(new ImagePiecePainter(img, 64));
		swingChessBoard.setPosition(position);
		
		JFrame frm = new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 600, 600);
		frm.add(swingChessBoard);
		frm.setVisible(true);
	}

}