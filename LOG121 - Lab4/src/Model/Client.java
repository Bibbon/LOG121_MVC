package Model;

import java.util.Observable;
import java.util.Observer;

import View.MainWindow;
import Controller.ImageSelector;



public class Client {
	
	

	private Perspective perspective1;
	private Perspective perspective2;
	private Thumbnail mainImage;
	private MainWindow mainWindow;

	
	
	public Client(){
		ImageSelector imageSelector = new ImageSelector();
		mainImage = new Thumbnail(imageSelector.getBufferedImage());
		perspective1 = new Perspective(imageSelector.getBufferedImage());
		perspective2 = new Perspective(imageSelector.getBufferedImage());
		mainWindow = new MainWindow(imageSelector.getBufferedImage());
		perspective1.addObserver(mainWindow.getMainPanel().getPerspectiveView1());
		perspective2.addObserver(mainWindow.getMainPanel().getPerspectiveView2());
		mainImage.addObserver(mainWindow.getMainPanel().getThumbnailView());
		
	
	}
	
	public Perspective getPerspective1() {
		return perspective1;
	}

	public void setPerspective1(Perspective perspective1) {
		this.perspective1 = perspective1;
	}

	public Perspective getPerspective2() {
		return perspective2;
	}

	public void setPerspective2(Perspective perspective2) {
		this.perspective2 = perspective2;
	}

	public Thumbnail getMainImage() {
		return mainImage;
	}

	public void setMainImage(Thumbnail mainImage) {
		this.mainImage = mainImage;
	}

	
	
	
	
	
	public static void main(String [] args){
		Client client = new Client();
		
		
	}





}
