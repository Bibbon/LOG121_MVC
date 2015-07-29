/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
�tudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagn�
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: ZoomOutCommand.java
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

public class ZoomOutCommand implements ViewCommand {

	private Perspective perspective;

	// Dimensions de la nouvelle image
	private int newImageWidth;
	private int newImageHeight;

	// �tat de l'image avant la modification
	private BufferedImage previousImage;
	// �tat de l'image apr�s la modification
	private BufferedImage newImage;

	private static final int SCALING_FACTOR = 2;

	public ZoomOutCommand(Perspective perspective) {

		this.perspective = perspective;
		previousImage = perspective.getVisibleImage();
		// Calcul des dimensions de la nouvelle image
		newImageWidth = perspective.getVisibleImage().getWidth()
				/ SCALING_FACTOR;
		newImageHeight = perspective.getVisibleImage().getHeight()
				/ SCALING_FACTOR;
		newImage = new BufferedImage(newImageWidth, newImageHeight, perspective
				.getVisibleImage().getType());
	}

	public void execute() {
		// Calcul du nouveau zoom et modification de l'image visible
		Graphics2D g = newImage.createGraphics();
		g.drawImage(perspective.getFullImage(), perspective.getTranslationX(),
				perspective.getTranslationY(), newImageWidth, newImageHeight,
				null);
		g.dispose();
		perspective.setVisibleImage(newImage);
	}

	public void undo() {
		// Set l'image visible � sa valeur pr�c�dente
		perspective.setVisibleImage(previousImage);
	}

	public void redo() {
		// Set l'image visible � sa valeur zoom�e
		perspective.setVisibleImage(newImage);
	}
}
