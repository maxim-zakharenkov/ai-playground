package minimax.chess.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class ImageSegment {

	private Image image;
	private int x;
	private int y;
	private int height;
	private int width;

	public ImageSegment(Image image, int x, int y, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void paint(Component component, Graphics g, int destX1, int destY1, int destX2, int destY2) {
		//		           dx1,   dy1,   dx2,         dy2,            sx1, sy1, sx2,       sy2
		g.drawImage(image, destX1, destY1, destX2, destY2, x,   y,   x + width, y + height, component);
	}
}
