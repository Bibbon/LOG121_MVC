package Controller;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Perspective;
import Model.Thumbnail;
import View.MainWindow;

public class Client {

	private Perspective perspective1;
	private Perspective perspective2;
	private Thumbnail mainImage;
	private MainWindow mainWindow;
	private ImageSelector imageSelector;

	public Client() {
		imageSelector = new ImageSelector();
		mainImage = new Thumbnail(imageSelector.getBufferedImage());
		perspective1 = new Perspective(imageSelector.getBufferedImage());
		perspective2 = new Perspective(imageSelector.getBufferedImage());
		mainWindow = new MainWindow(imageSelector.getBufferedImage(),
				new ViewListener());
		perspective1.addObserver(mainWindow.getMainPanel()
				.getPerspectiveView1());
		perspective2.addObserver(mainWindow.getMainPanel()
				.getPerspectiveView2());
		mainImage.addObserver(mainWindow.getMainPanel().getThumbnailView());
		mainImage.addObserver(perspective1);
		mainImage.addObserver(perspective2);

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

	public static void main(String[] args) {
		Client client = new Client();
		client.getClass();

	}

	public class ViewListener implements ActionListener {

		// Memorise the title of a bouton
		private String ButtonName;
		private String viewSource;
		private int translationY;
		private int translationX;

		public void actionPerformed(ActionEvent arg0) {

			// Memorise the value of the click button
			ButtonName = arg0.getActionCommand();


			// If Direction button, need to go further
			if (ButtonName == "Up" || ButtonName == "Down"
					|| ButtonName == "Left" || ButtonName == "Right")
				viewSource = (String) ((Component) arg0.getSource())
						.getParent().getParent().getParent().getName();
			else if (ButtonName == "ZoomIn" || ButtonName == "ZoomOut"
					|| ButtonName == "Save")
				viewSource = (String) ((Component) arg0.getSource())
						.getParent().getParent().getName();

			switch (ButtonName) {
			case ("Open Image"):
				ImageSelector iS = new ImageSelector();
				mainImage.setImage(iS.getBufferedImage());
				break;
			case ("Save All"):
				break;
			case ("Open Project"):
			    break;
			case ("Save"):

				imageSelector.SaveImage();
				File imageOutput = imageSelector.getImageFile();

				if (viewSource == "P1") {
					try {
						ImageIO.write(perspective1.getVisibleImage(), "png",
								imageOutput);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						ImageIO.write(perspective2.getVisibleImage(), "png",
								imageOutput);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			case ("Undo"):
				// CommandManager.getInstance().Undo();
				System.out.println("Undo");
				break;
			case ("ZoomIn"):

				if (viewSource == "P1") {
					int newImageWidth = perspective1.getVisibleImage()
							.getWidth() * 2;
					int newImageHeight = perspective1.getVisibleImage()
							.getHeight() * 2;
					BufferedImage resizedImage = new BufferedImage(
							newImageWidth, newImageHeight, perspective1
									.getVisibleImage().getType());
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth,
							newImageHeight, null);
					g.dispose();
					perspective1.setVisibleImage(resizedImage);
					// CommandManager.getInstance().zoomIn(perspective1);
				} else {
					int newImageWidth = perspective2.getVisibleImage()
							.getWidth() * 2;
					int newImageHeight = perspective2.getVisibleImage()
							.getHeight() * 2;
					BufferedImage resizedImage = new BufferedImage(
							newImageWidth, newImageHeight, perspective2
									.getVisibleImage().getType());
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth,
							newImageHeight, null);
					g.dispose();
					perspective2.setVisibleImage(resizedImage);
					// CommandManager.getInstance().zoomIn(perspective2);
				}
				System.out.println(ButtonName + " " + viewSource);
				break;
			case ("ZoomOut"):

				if (viewSource == "P1") {
					int newImageWidth1 = perspective1.getVisibleImage()
							.getWidth() / 2;
					int newImageHeight1 = perspective1.getVisibleImage()
							.getHeight() / 2;
					BufferedImage resizedImage1 = new BufferedImage(
							newImageWidth1, newImageHeight1, perspective1
									.getVisibleImage().getType());
					Graphics2D g1 = resizedImage1.createGraphics();
					g1.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth1,
							newImageHeight1, null);
					g1.dispose();
					perspective1.setVisibleImage(resizedImage1);
					// CommandManager.getInstance().zoomIn(perspective1);
				} else {
					int newImageWidth1 = perspective2.getVisibleImage()
							.getWidth() / 2;
					int newImageHeight1 = perspective2.getVisibleImage()
							.getHeight() / 2;
					BufferedImage resizedImage1 = new BufferedImage(
							newImageWidth1, newImageHeight1, perspective2
									.getVisibleImage().getType());
					Graphics2D g1 = resizedImage1.createGraphics();
					g1.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth1,
							newImageHeight1, null);
					g1.dispose();
					perspective2.setVisibleImage(resizedImage1);
					// CommandManager.getInstance().zoomIn(perspective2);
				}

				System.out.println(ButtonName + " " + viewSource);
				break;
			case ("Up"):
				
		int newImageWidth = perspective1.getVisibleImage().getWidth();
		int newImageHeight = perspective1.getVisibleImage().getHeight();
		BufferedImage resizedImage = new BufferedImage(newImageWidth, newImageHeight, perspective1.getVisibleImage().getType());
		Graphics2D g = resizedImage.createGraphics();
		translationY -= 10;
		g.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth,newImageHeight, null);
		g.dispose();
		perspective1.setVisibleImage(resizedImage);
				/*
				 * if(viewSource == "P1")
				 * CommandManager.getInstance().move(perspective1, 0, 5); else
				 * CommandManager.getInstance().move(perspective2, 0, 5);
				 */
				System.out.println(ButtonName + " " + viewSource);
				break;
			case ("Down"):
				
			int newImageWidth1 = perspective1.getVisibleImage().getWidth();
			int newImageHeight1 = perspective1.getVisibleImage().getHeight();
			BufferedImage resizedImage1 = new BufferedImage(newImageWidth1, newImageHeight1, perspective1.getVisibleImage().getType());
			Graphics2D g1 = resizedImage1.createGraphics();
			translationY += 10;
			g1.drawImage(mainImage.getImage(), translationX, translationY, newImageWidth1,newImageHeight1, null);
			g1.dispose();
			perspective1.setVisibleImage(resizedImage1);
				/*
				 * if(viewSource == "P1")
				 * CommandManager.getInstance().move(perspective1, 0, -5); else
				 * CommandManager.getInstance().move(perspective2, 0, -5);
				 */
				System.out.println(ButtonName + " " + viewSource);
				break;
			case ("Right"):
				/*
				 * if(viewSource == "P1")
				 * CommandManager.getInstance().move(perspective1, 5, 0); else
				 * CommandManager.getInstance().move(perspective2, 5, 0);
				 */
				System.out.println(ButtonName + " " + viewSource);
				break;
			case ("Left"):
				/*
				 * if(viewSource == "P1")
				 * CommandManager.getInstance().move(perspective1, -5, 0); else
				 * CommandManager.getInstance().move(perspective2, -5, 0);
				 */
				System.out.println(ButtonName + " " + viewSource);
				break;

			}

			// END actionPerformed()
		}

	}

}
