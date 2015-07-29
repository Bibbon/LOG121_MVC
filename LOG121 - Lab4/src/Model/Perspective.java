package Model;

import java.awt.image.BufferedImage;
import java.util.*;

public class Perspective extends Observable implements Observer{
	
	//Facteurs de translation appliqués à l'image dans la perspective
	private int translationX;
	private int translationY;
	
	//Image principale
	private BufferedImage fullImage;
	//Portion de l'image visible à l'écran
	private BufferedImage visibleImage;
	
	
	
	public Perspective(BufferedImage image) {
		super();
		
		this.fullImage = image;
		this.visibleImage = image;
		this.translationX = 0;
		this.translationY = 0;
	}
	
	public int getTranslationX() {
		return translationX;
	}

	public void setTranslationX(int translationX) {
		this.translationX = translationX;
	}

	public int getTranslationY() {
		return translationY;
	}

	public void setTranslationY(int translationY) {
		this.translationY = translationY;
	}

	public BufferedImage getFullImage() {
		return fullImage;
	}

	public void setFullImage(BufferedImage fullImage) {
		this.fullImage = fullImage;
	}
	
	public BufferedImage getVisibleImage() {
		return visibleImage;
	}

	public void setVisibleImage(BufferedImage visibleImage) {
		this.visibleImage = visibleImage;
		setChanged();
		notifyObservers(this.visibleImage);
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		//Sert à updater l'image dans la perspective lorsqu'on change d'image principale
		setVisibleImage((BufferedImage) arg1);
		setFullImage((BufferedImage) arg1);
		translationX = 0;
		translationY = 0;
		
	}
	
}
