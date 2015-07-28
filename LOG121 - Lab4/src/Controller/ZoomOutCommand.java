package Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Model.Perspective;


public class ZoomOutCommand implements ViewCommand{

	private Perspective perspective;
	


	private int newImageWidth;
	private int newImageHeight;
	 
	private BufferedImage resizedImage;
	private BufferedImage previousImage;
	
	private static final int SCALING_FACTOR = 2;
	
	public ZoomOutCommand(Perspective perspective){
		
		this.perspective = perspective;
	    previousImage = perspective.getVisibleImage();
		newImageWidth = perspective.getVisibleImage().getWidth() / SCALING_FACTOR;
		newImageHeight = perspective.getVisibleImage().getHeight() / SCALING_FACTOR;
		resizedImage = new BufferedImage(newImageWidth, newImageHeight, perspective.getVisibleImage().getType());
	}
	
	

	public void execute(){
		
		//perspective.setCoordinates(newX1, newY1, newX2, newY2);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(perspective.getFullImage(), perspective.getTranslationX(), perspective.getTranslationY(), newImageWidth,newImageHeight, null);
		g.dispose();
		perspective.setVisibleImage(resizedImage);
	}
	
	public void undo(){
		
		perspective.setVisibleImage(previousImage);
	}
}
