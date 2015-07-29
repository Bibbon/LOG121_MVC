package Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Model.Perspective;

public class MoveDownCommand implements ViewCommand {

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

	public MoveDownCommand(Perspective perspective) {

		this.perspective = perspective;
		previousImage = perspective.getVisibleImage();
		newImageWidth = perspective.getVisibleImage().getWidth();
		newImageHeight = perspective.getVisibleImage().getHeight();
		newImage = new BufferedImage(newImageWidth, newImageHeight, perspective
				.getVisibleImage().getType());
	}

	public void execute() {

		Graphics2D g = newImage.createGraphics();
		perspective.setTranslationY(perspective.getTranslationY()
				+ TRANSLATION_FACTOR);
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
		perspective.setTranslationY(perspective.getTranslationY()
				- TRANSLATION_FACTOR);
	}

	public void redo() {
		// Set de l'image à sa valeur calculée
		perspective.setVisibleImage(newImage);
		// Mise à jour de la distance par rapport à l'image centrée
		perspective.setTranslationY(perspective.getTranslationY()
				+ TRANSLATION_FACTOR);
	}
}
