package Model;

import java.awt.image.BufferedImage;
import java.util.Observable;

public class Thumbnail extends Observable{
	private BufferedImage image;
	
	
	
	
	public Thumbnail(BufferedImage image){
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		setChanged();
		notifyObservers();
	}

}
