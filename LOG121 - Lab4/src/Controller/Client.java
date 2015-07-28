package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				CommandManager.getInstance().undo();
				break;
			case ("ZoomIn"):

				if (viewSource == "P1") {
				CommandManager.getInstance().zoomIn(perspective1);
				} 
				else {
				CommandManager.getInstance().zoomIn(perspective2);
				}
				break;
				
			case ("ZoomOut"):

				if (viewSource == "P1") {
					 CommandManager.getInstance().zoomOut(perspective1);
				} 
				else {
					 CommandManager.getInstance().zoomOut(perspective2);
				}
				break;
				
			
			case ("Up"):			
				
				 if(viewSource == "P1")
				 CommandManager.getInstance().moveUp(perspective1); 
				 else
				 CommandManager.getInstance().moveUp(perspective2);
				 
				break;
			case ("Down"):
				
				 if(viewSource == "P1")
				 CommandManager.getInstance().moveDown(perspective1); 
				 else
				 CommandManager.getInstance().moveDown(perspective2);
				 
				break;
			case ("Right"):
				
				 if(viewSource == "P1")
				 CommandManager.getInstance().moveRight(perspective1); 
				 else
				 CommandManager.getInstance().moveRight(perspective2);
				 
				break;
			case ("Left"):
				
				 if(viewSource == "P1")
				 CommandManager.getInstance().moveLeft(perspective1); 
				 else
				 CommandManager.getInstance().moveLeft(perspective2);
				 
				break;

			}

			// END actionPerformed()
		}

	}

}
