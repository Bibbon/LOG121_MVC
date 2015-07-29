package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
		mainWindow = new MainWindow(imageSelector.getBufferedImage(),new ViewListener());
		perspective1.addObserver(mainWindow.getMainPanel().getPerspectiveView1());
		perspective2.addObserver(mainWindow.getMainPanel().getPerspectiveView2());
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
		private Perspective newProjectPerspective1;
		private Perspective newProjectPerspective2;
		private Thumbnail newProjectMainImage;


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
				ProjectSelector projectSelector = new ProjectSelector();
			    projectSelector.SaveProject();
			    try {
					FileOutputStream out = new FileOutputStream(projectSelector.getprojectFile());
					ObjectOutputStream ObOut = new ObjectOutputStream(out);
					
					ObOut.writeObject(mainImage);
					ObOut.writeObject(perspective1);
					ObOut.writeObject(perspective2);
					ObOut.close();
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "File not found");
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Could not write file");;
				}
				break;
			case ("Open Project"):
				ProjectSelector projectSelector2 = new ProjectSelector();
		    projectSelector2.LoadProject();
		    try {
				FileInputStream in = new FileInputStream(projectSelector2.getprojectFile().getAbsolutePath());
				ObjectInputStream ObIn = new ObjectInputStream(in);
				
				newProjectMainImage = (Thumbnail) ObIn.readObject();
				newProjectPerspective1 = (Perspective) ObIn.readObject();
				newProjectPerspective2 = (Perspective) ObIn.readObject();
				ObIn.close();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Could not read file");
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Unknown class found");
			}
		    
			mainImage.setImage(newProjectMainImage.getImage());
			perspective1.setTranslationX(newProjectPerspective1.getTranslationX());
			perspective1.setTranslationY(newProjectPerspective1.getTranslationY());
			perspective2.setTranslationX(newProjectPerspective2.getTranslationX());
			perspective2.setTranslationY(newProjectPerspective2.getTranslationY());
			perspective1.setVisibleImage(newProjectPerspective1.getVisibleImage());
			perspective2.setVisibleImage(newProjectPerspective2.getVisibleImage());
			CommandManager.getInstance().clearStacks();
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
			case ("Redo"):
				CommandManager.getInstance().redo();
				break;
			case ("ZoomIn"):

				if (viewSource == "P1") {
					CommandInvoker.zoomIn(perspective1);
				} 
				else {
					CommandInvoker.zoomIn(perspective2);
				}
				break;
				
			case ("ZoomOut"):

				if (viewSource == "P1") {
					CommandInvoker.zoomOut(perspective1);
				} 
				else {
					CommandInvoker.zoomOut(perspective2);
				}
				break;
				
			
			case ("Up"):			
				
				 if(viewSource == "P1")
					 CommandInvoker.moveUp(perspective1); 
				 else
					 CommandInvoker.moveUp(perspective2);
				 
				break;
			case ("Down"):
				
				 if(viewSource == "P1")
					 CommandInvoker.moveDown(perspective1); 
				 else
					 CommandInvoker.moveDown(perspective2);
				 
				break;
			case ("Right"):
				
				 if(viewSource == "P1")
					 CommandInvoker.moveRight(perspective1); 
				 else
					 CommandInvoker.moveRight(perspective2);
				 
				break;
			case ("Left"):
				
				 if(viewSource == "P1")
					 CommandInvoker.moveLeft(perspective1); 
				 else
					 CommandInvoker.moveLeft(perspective2);
				 
				break;

			}

			// END actionPerformed()
		}

	}

}
