package Model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.*;

public class Perspective extends Observable{
	
	private Point topLeftCorner;
	private Point bottomRightCorner;
	private int height;
	private int width;
	private BufferedImage image;
	
	
	
	public Perspective(BufferedImage image) {
		super();
		this. height = image.getHeight();
		this.width = image.getWidth();
		this.topLeftCorner = new Point(0, 0);
		this.bottomRightCorner = new Point(width, height);
		this.image = image;
	}

	public Point getTopLeftCorner() {
		return topLeftCorner;
	}
	
	public void setTopLeftCorner(Point topLeftCorner) {
		this.topLeftCorner = topLeftCorner;
	}
	
	public Point getBottomRightCorner() {
		return bottomRightCorner;
	}
	
	public void setBottomRightCorner(Point bottomRightCorner) {
		this.bottomRightCorner = bottomRightCorner;
	}

	public void setCoordinates(int minX, int minY, int maxX, int maxY) {
		
		this.topLeftCorner.x = (minX >= 0) ? minX: 0;
		this.topLeftCorner.y = (minY >= 0) ? minY: 0;
		this.bottomRightCorner.x = (maxX <= width) ? maxX: width;
		this.bottomRightCorner.y = (maxY <= height) ? maxY: height;
		setChanged();
		notifyObservers();
		
		
	}
	
	
}
