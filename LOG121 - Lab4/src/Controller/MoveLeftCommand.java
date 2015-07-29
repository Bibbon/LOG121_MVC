/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: MoveLeftCommand.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Model.Perspective;

public class MoveLeftCommand implements ViewCommand {

	private Perspective perspective;

	// Dimensions de la nouvelle image
	private int newImageWidth;
	private int newImageHeight;

	// État de l'image avant la modification
	private BufferedImage previousImage;
	// État de l'image après la modification
	private BufferedImage newImage;

	// Distance d'un déplacement
	private static final int TRANSLATION_FACTOR = 10;

	public MoveLeftCommand(Perspective perspective) {

		this.perspective = perspective;
		previousImage = perspective.getVisibleImage();
		newImageWidth = perspective.getVisibleImage().getWidth();
		newImageHeight = perspective.getVisibleImage().getHeight();
		newImage = new BufferedImage(newImageWidth, newImageHeight, perspective
				.getVisibleImage().getType());
	}

	public void execute() {

		Graphics2D g = newImage.createGraphics();
		perspective.setTranslationX(perspective.getTranslationX()
				- TRANSLATION_FACTOR);
		g.drawImage(perspective.getFullImage(), perspective.getTranslationX(),
				perspective.getTranslationY(), newImageWidth, newImageHeight,
				null);
		g.dispose();
		perspective.setVisibleImage(newImage);
	}

	public void undo() {
		// Set de l'image à sa valeur précédente
		perspective.setVisibleImage(previousImage);
		// Mise à jour de la distance par rapport à l'image centrée
		perspective.setTranslationX(perspective.getTranslationX()
				+ TRANSLATION_FACTOR);
	}

	public void redo() {
		// Set de l'image à sa valeur calculée
		perspective.setVisibleImage(newImage);
		// Mise à jour de la distance par rapport à l'image centrée
		perspective.setTranslationX(perspective.getTranslationX()
				- TRANSLATION_FACTOR);
	}
}
