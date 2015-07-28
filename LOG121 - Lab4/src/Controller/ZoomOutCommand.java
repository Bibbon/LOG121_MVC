package Controller;

import Model.Perspective;

public class ZoomOutCommand implements ViewCommand{

	private Perspective perspective;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int centerX;
	private int centerY;

	private int newX1;
	private int newY1;
	private int newX2;
	private int newY2;
	private int newCenterX;
	private int newCenterY;
	
	private static final int SCALING_FACTOR = 2;
	
	public ZoomOutCommand(Perspective perspective){
		
		this.perspective = perspective;

		x1 = perspective.getVisibleX1();
		y1 = perspective.getVisibleY1();
		x2 = perspective.getVisibleX2();
		y2 = perspective.getVisibleY2();
		
		centerX = x2 - x1;
		centerY = y2 - y1;

		newCenterX = centerX;
		newCenterY = centerY;

		calculateNewPosition();
	}
	
	public ZoomOutCommand(Perspective perspective, int x, int y){
		
		this.perspective = perspective;

		x1 = perspective.getVisibleX1();
		y1 = perspective.getVisibleY1();
		x2 = perspective.getVisibleX2();
		y2 = perspective.getVisibleY2();
		
		centerX = x2 - x1;
		centerY = y2 - y1;
		
		newCenterX = x;
		newCenterY = y;

		calculateNewPosition();
	}
	
	private void calculateNewPosition(){
		
		newX1 = newCenterX - ((centerX - x1)*SCALING_FACTOR);
		newY1 = newCenterY - ((centerY - y1)*SCALING_FACTOR);
		newX2 = newCenterX + ((x2 - centerX)*SCALING_FACTOR);
		newY2 = newCenterY + ((y2 - centerY)*SCALING_FACTOR);
		
	}

	public void execute(){
		
		perspective.setCoordinates(newX1, newY1, newX2, newY2);
	}
	
	public void undo(){
		
		perspective.setCoordinates(x1, y1, x2, y2);
	}
}
