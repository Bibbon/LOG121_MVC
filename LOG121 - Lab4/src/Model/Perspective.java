package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

<<<<<<< HEAD
public class Perspective extends Observable implements Observer{
=======
import javax.imageio.ImageIO;

public class Perspective extends Observable implements Observer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 502896813583984078L;
	private int fullHeight;
	private int fullWidth;
	
	private int visibleX1;
	private int visibleY1;
	private int visibleX2;
	private int visibleY2;
>>>>>>> 413141897de45559cc57aae2fc92e673663a9595
	
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
<<<<<<< HEAD
=======


	public BufferedImage getFullImage() {
		return fullImage;
	}


	public void setFullImage(BufferedImage fullImage) {
		this.fullImage = fullImage;
	}
	
	private void readObject(ObjectInputStream ois) throws IOException{
		visibleImage = ImageIO.read(ois);
		fullImage = ImageIO.read(ois);
		translationX = ois.read();
		translationY = ois.read();
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		ImageIO.write(visibleImage, "PNG", oos);
		ImageIO.write(fullImage, "PNG", oos);
		oos.write(translationX);
		oos.write(translationY);
}







	
>>>>>>> 413141897de45559cc57aae2fc92e673663a9595
	
}
