/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: Thumbnail.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

import javax.imageio.ImageIO;

public class Thumbnail extends Observable implements Serializable {

	private static final long serialVersionUID = 502896813583984078L;

	// Image principale de l'application
	private BufferedImage image;

	// Créateur
	public Thumbnail(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		setChanged();
		notifyObservers(image);
	}

	// Récupération de la sauvegarde
	private void readObject(ObjectInputStream ois) throws IOException {
		image = ImageIO.read(ois);
	}

	// Sauvegarde
	private void writeObject(ObjectOutputStream oos) throws IOException {
		ImageIO.write(image, "PNG", oos);
	}

}
