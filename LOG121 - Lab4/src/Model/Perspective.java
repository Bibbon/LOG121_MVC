package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;

public class Perspective extends Observable implements Observer, Serializable {

	private static final long serialVersionUID = 502896813583984078L;

	// Facteurs de translation appliqu�s � l'image dans la perspective
	private int translationX;
	private int translationY;

	// Image principale
	private BufferedImage fullImage;
	// Portion de l'image visible � l'�cran
	private BufferedImage visibleImage;

	public Perspective(BufferedImage image) {
		super();

		this.fullImage = image;
		// L'image affich�e � la cr�ation est l'image enti�re
		this.visibleImage = image;

		// L'image est centr�e � la cr�ation
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
	// Sert � updater l'image dans la perspective lorsqu'on change d'image
	// principale
	public void update(Observable arg0, Object arg1) {
		setVisibleImage((BufferedImage) arg1);
		setFullImage((BufferedImage) arg1);
		translationX = 0;
		translationY = 0;
	}

	// R�cup�ration de la sauvegarde
	private void readObject(ObjectInputStream ois) throws IOException {
		visibleImage = ImageIO.read(ois);
		fullImage = ImageIO.read(ois);
		translationX = ois.read();
		translationY = ois.read();
	}

	// Sauvegarde
	private void writeObject(ObjectOutputStream oos) throws IOException {
		ImageIO.write(visibleImage, "PNG", oos);
		ImageIO.write(fullImage, "PNG", oos);
		oos.write(translationX);
		oos.write(translationY);
	}

}
