/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
�tudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagn�
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: MoveLeftCommand.java
Date cr��: 2015-07-25
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

	// �tat de l'image avant la modification
	private BufferedImage previousImage;
	// �tat de l'image apr�s la modification
	private BufferedImage newImage;

	// Distance d'un d�placement
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
		// Set de l'image � sa valeur pr�c�dente
		perspective.setVisibleImage(previousImage);
		// Mise � jour de la distance par rapport � l'image centr�e
		perspective.setTranslationX(perspective.getTranslationX()
				+ TRANSLATION_FACTOR);
	}

	public void redo() {
		// Set de l'image � sa valeur calcul�e
		perspective.setVisibleImage(newImage);
		// Mise � jour de la distance par rapport � l'image centr�e
		perspective.setTranslationX(perspective.getTranslationX()
				- TRANSLATION_FACTOR);
	}
}
