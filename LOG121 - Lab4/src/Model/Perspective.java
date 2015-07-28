package Model;

import java.awt.image.BufferedImage;
import java.util.*;

public class Perspective extends Observable implements Observer{

	private int fullHeight;
	private int fullWidth;
	
	private int visibleX1;
	private int visibleY1;
	private int visibleX2;
	private int visibleY2;
	
	private BufferedImage fullImage;
	private BufferedImage visibleImage;
	
	
	
	public Perspective(BufferedImage image) {
		super();
		this.fullHeight = image.getHeight();
		this.fullWidth = image.getWidth();
		
		this.visibleX1 = 0;
		this.visibleY1 = 0;
		this.visibleX2 = 0;
		this.visibleY2 = 0;
		this.fullImage = image;
		this.visibleImage = image;
	}
	
	

	public int getVisibleX1() {
		return visibleX1;
	}



	public void setVisibleX1(int visibleX1) {
		this.visibleX1 = visibleX1;
	}



	public int getVisibleY1() {
		return visibleY1;
	}



	public void setVisibleY1(int visibleY1) {
		this.visibleY1 = visibleY1;
	}



	public int getVisibleX2() {
		return visibleX2;
	}



	public void setVisibleX2(int visibleX2) {
		this.visibleX2 = visibleX2;
	}



	public int getVisibleY2() {
		return visibleY2;
	}



	public void setVisibleY2(int visibleY2) {
		this.visibleY2 = visibleY2;
	}
	
	
	public BufferedImage getVisibleImage() {
		return visibleImage;
	}



	public void setVisibleImage(BufferedImage visibleImage) {
		this.visibleImage = visibleImage;
		setChanged();
		notifyObservers(this.visibleImage);
	}



	public void setCoordinates(int minX, int minY, int maxX, int maxY) {
		
		this.visibleX1 = (minX >= 0) ? minX: 0;
		this.visibleY1 = (minY >= 0) ? minY: 0;
		this.visibleX2 = (maxX <= fullWidth) ? maxX: fullWidth;
		this.visibleY2 = (maxY <= fullHeight) ? maxY: fullHeight;
		
		setVisibleImage(fullImage.getSubimage(minX, minY, maxX - minX, maxY - minY));	
		
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		setVisibleImage((BufferedImage) arg1);
		
	}




	
	
}
