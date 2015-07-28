package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import Model.Perspective;
import Model.Thumbnail;
import View.MainWindow;

public class Client {

	private Perspective perspective1;
	private Perspective perspective2;
	private Thumbnail mainImage;
	private MainWindow mainWindow;

	public Client() {
		ImageSelector imageSelector = new ImageSelector();
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

	}

	public class ViewListener implements ActionListener {

		// Memorise the title of a bouton
		private String ButtonName;

		public void actionPerformed(ActionEvent arg0) {

			// Memorise the value of the click button
			ButtonName = arg0.getActionCommand();

			switch (ButtonName) {
			case ("Open Image"):
				ImageSelector iS = new ImageSelector();
				mainImage.setImage(iS.getBufferedImage());
				break;
			case ("Undo"):
				//CommandManager.getInstance().Undo();
				System.out.println(ButtonName);
				break;
			case ("ZoomIn P1"):
				//CommandManager.getInstance().zoomIn(perspective1);
				System.out.println(ButtonName);
				break;
			case ("ZoomIn P2"):
				//CommandManager.getInstance().zoomIn(perspective2);
				System.out.println(ButtonName);
				break;
			case ("ZoomOut P1"):
				//CommandManager.getInstance().zoomOut(perspective1);
				System.out.println(ButtonName);
				break;
			case ("ZoomOut P2"):
				//CommandManager.getInstance().zoomOut(perspective2);
				System.out.println(ButtonName);
				break;
			case ("Up P1"):
				//CommandManager.getInstance().move(perspective1, 0, 5);
				System.out.println(ButtonName);
				break;
			case ("Down P1"):
				//CommandManager.getInstance().move(perspective1, 0, -5);
				System.out.println(ButtonName);
				break;
			case ("Right P1"):
				//CommandManager.getInstance().move(perspective1, 5, 0);
				System.out.println(ButtonName);
				break;
			case ("Left P1"):
				//CommandManager.getInstance().move(perspective1, -5, 0);
				System.out.println(ButtonName);
				break;
			case ("Up P2"):
				//CommandManager.getInstance().move(perspective2, 0, 5);
				System.out.println(ButtonName);
				break;
			case ("Down P2"):
				//CommandManager.getInstance().move(perspective2, 0, -5);
				System.out.println(ButtonName);
				break;
			case ("Right P2"):
				//CommandManager.getInstance().move(perspective2, 5, 0);
				System.out.println(ButtonName);
				break;
			case ("Left P2"):
				//CommandManager.getInstance().move(perspective2, -5, 0);
				System.out.println(ButtonName);
				break;
			}

			// END actionPerformed()
		}

	}

}
