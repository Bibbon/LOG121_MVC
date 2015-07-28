package Controller;

import Model.Perspective;

public class ZoomOutCommand implements ViewCommand{

	private Perspective perspective;
	
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	private int centerX;
	private int centerY;

	private int newMinX;
	private int newMinY;
	private int newMaxX;
	private int newMaxY;
	private int newCenterX;
	private int newCenterY;
	
	private static final int SCALING_FACTOR = 2;
	
	public ZoomOutCommand(Perspective perspective){
		
		this.perspective = perspective;

		minX = perspective.getTopLeftCorner().x;
		minY = perspective.getTopLeftCorner().y;
		maxX = perspective.getBottomRightCorner().x;
		maxY = perspective.getBottomRightCorner().y;
		
		centerX = maxX - minX;
		centerY = maxY - minY;

		newCenterX = centerX;
		newCenterY = centerY;

		calculateNewPosition();
	}
	
	public ZoomOutCommand(Perspective perspective, int x, int y){
		
		this.perspective = perspective;

		minX = perspective.getTopLeftCorner().x;
		minY = perspective.getTopLeftCorner().y;
		maxX = perspective.getBottomRightCorner().x;
		maxY = perspective.getBottomRightCorner().y;
		
		centerX = maxX - minX;
		centerY = maxY - minY;
		
		newCenterX = x;
		newCenterY = y;

		calculateNewPosition();
	}
	
	private void calculateNewPosition(){
		
		newMinX = newCenterX - ((centerX - minX)*SCALING_FACTOR);
		newMinY = newCenterY - ((centerY - minY)*SCALING_FACTOR);
		newMaxX = newCenterX + ((maxX - centerX)*SCALING_FACTOR);
		newMaxY = newCenterY + ((maxY - centerY)*SCALING_FACTOR);
		
	}

	public void execute(){
		
		perspective.setCoordinates(newMinX, newMinY, newMaxX, newMaxY);
	}
	
	public void undo(){
		
		perspective.setCoordinates(minX, minY, maxX, maxY);
	}
}
