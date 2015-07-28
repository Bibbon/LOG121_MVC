package Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Model.Perspective;


public class MoveUpCommand implements ViewCommand{

	private Perspective perspective;
	
	private int newImageWidth;
	private int newImageHeight;
	 
	private BufferedImage resizedImage;
	private BufferedImage previousImage;
	
	private static final int TRANSLATION_FACTOR = 10;
	
	public MoveUpCommand(Perspective perspective){
		
		this.perspective = perspective;
	    previousImage = perspective.getVisibleImage();
		newImageWidth = perspective.getVisibleImage().getWidth();
		newImageHeight = perspective.getVisibleImage().getHeight();
		resizedImage = new BufferedImage(newImageWidth, newImageHeight, perspective.getVisibleImage().getType());
	}
	
	

	public void execute(){
		
		//perspective.setCoordinates(newX1, newY1, newX2, newY2);
		Graphics2D g = resizedImage.createGraphics();
		perspective.setTranslationY(perspective.getTranslationY() - TRANSLATION_FACTOR);
		g.drawImage(perspective.getFullImage(), perspective.getTranslationX(), perspective.getTranslationY(), newImageWidth,newImageHeight, null);
		g.dispose();
		perspective.setVisibleImage(resizedImage);
	}
	
	public void undo(){
		
		perspective.setVisibleImage(previousImage);
	}
	
	public void redo(){
		
		perspective.setVisibleImage(resizedImage);
	}
}
